
Vue.filter('moment', function (value, formatString) {
    formatString = formatString || 'YYYY-MM-DD HH:mm:ss';
    // return moment(value).format(formatString); // value可以是普通日期 20170723
    return moment.unix(value).format(formatString); // 这是时间戳转时间
});
Vue.component('my-content', {
    template: "#main-template",
    data: function () {
        return {
            org: JSON.parse(localStorage.getItem('org')),
            user: JSON.parse(localStorage.getItem('user')),
            date: moment().format('YYYY-MM-DD HH:mm:ss'),
            datatable_obj: null,
            statusList: [{
                "id": "新报修",
                "text": "新报修"
            },
            {
                "id": "待维修",
                "text": "待维修"
                // "selected": true
            },
            {
                "id": "已修好",
                "text": "已修好"

            }],//状态列表
            customerList: [],//客户列表
            deviceNameList: [],//设备列表
            taskList: []//报修列表
        }
    },
    computed: {},
    watch: {},
    methods: {
        FnAlert: function () {
            swal("操作有误!", "请选择要编辑的数据行!", "error");
        },
        filterGlobal: function () {//全局搜素
            $('#merchant-list').DataTable().search(
                $('#global_filter').val(), true, true
            ).draw();
        },
        Fnsearch: function (val, i) {//某列搜素 val为搜索的内容，i为database第几列（第一列为0）
            $('#merchant-list').DataTable().column(i).search(
                val ? '^' + val + '$' : '', true, true
            ).draw();
        },
        FnEditCancel: function (modalid) {//弹窗取消修改
            swal({
                title: "确定要关闭窗口吗?",
                text: "一旦关闭，将取消编辑操作!",
                icon: "warning",
                buttons: true,
                dangerMode: true,
            })
                .then(function (willDelete) {
                    if (willDelete) {
                        //TODO 添加&修改操作
                        $(modalid).modal("hide");
                    } else {
                        swal("没有操作!");
                    }
                });
        },
        orgGetBindList: function () {//获取用户列表
            // /org/getBindList 获取绑定组织列表
            var _self = this;
            $.ajax({
                type: 'post',
                dataType: 'json',
                contentType: "application/json; charset=utf-8;",
                xhrFields: {
                    //设置跨域请求
                    withCredentials: true
                },
                async: false,
                url: jQuery.url + '/org/getBindList',
                data: JSON.stringify({
                    "name": "",//关联组织的名称不是登录组织的名称
                    "pageNumber": 0,
                    "pageSize": 1000
                }),
                headers: {
                    'token': localStorage.getItem('token'),
                },
                success: function (data) {
                    console.log(JSON.stringify(data));
                    var Data = data.data;
                    if (data.code == 0) {
                        _self.customerList = $.map(data.data, function (obj) {
                            return { id: obj.id, name: obj.name };
                        });
                    }
                },
                err: function (err) {
                    alert(err);
                }
            })
        },
        equipmentGetList: function () {
            var _self = this;
            //获取设备列表
            $.ajax({
                type: 'post',
                dataType: 'json',
                contentType: "application/json; charset=utf-8;",
                xhrFields: {
                    //设置跨域请求
                    withCredentials: true
                },
                async: false,
                url: jQuery.url + '/equipment/getList',
                data: JSON.stringify({
                    "pageNumber": 0,
                    "pageSize": 10000,
                }),
                headers: {
                    'token': localStorage.getItem('token'),
                },
                success: function (data) {
                    // console.log(JSON.stringify(data));
                    var Data = data.data;
                    if (data.code == 0) {
                        _self.deviceNameList = $.map(data.data, function (obj) {
                            return { id: obj.id, name: obj.name };
                        });
                    }
                },
                err: function (err) {
                    swal("", err, "error");
                }
            });
        },
        taskGetList: function () {//获取报修列表数据
            console.log('taskGetList')
            var _self = this;
            $.ajax({
                type: 'post',
                dataType: 'json',
                contentType: "application/json; charset=utf-8;",
                xhrFields: {
                    //设置跨域请求
                    withCredentials: true
                },
                async: false,
                url: jQuery.url + '/task/getList',
                data: JSON.stringify({
                    "own": 0,//0所有的，1自己的
                    "pageNumber": 0,
                    "pageSize": 100000,
                    "status": ""//报修人1：未完成 2：已完成 3：已撤销//维修人 11新报修 12：待维修 13：已修好
                }),
                headers: {
                    'token': localStorage.getItem('token'),
                },
                success: function (data) {
                    console.log(JSON.stringify(data));
                    if (data.code == 0) {
                        _self.taskList = data.data;
                    }
                },
                err: function (err) {
                    swal("", err, "error")
                }
            });
        },
        initCategoryDataTables: function () {
            //绘制表格
            var _self = this;
            _self.datatable_obj = $('#merchant-list').DataTable({
                data: _self.taskList,
                columns: [
                    { data: 'taskNo' },//维修单号
                    { data: 'equipName' },//设备名称
                    { data: 'equipUsedDept' },//部门
                    { data: 'description' },//报修内容 任务描述
                    { data: 'createUserName' },//报修人
                    {
                        data: 'createTime',
                        render: function (data, type, row) {
                            return moment(data).format('YYYY-MM-DD');
                        }
                    },//报修时间
                    {
                        data: 'status',
                        render: function (data, type, row) {
                            //10、待受理 11、报修人撤销 12、维修人删除 20、待维修 21、报修人撤销 22、维修人删除 23、被拒绝 30、待确认 40、已完成 50、已关闭 ,
                            switch (data) {
                                case 10:
                                    return "待受理"
                                    break;
                                    case 11:
                                    return "报修人撤销"
                                    break;
                                    case 12:
                                    return "维修人删除"
                                    break;
                                    case 20:
                                    return "待维修"
                                    break;
                                    case 21:
                                    return "报修人撤销"
                                    break;
                                    case 22:
                                    return "维修人删除"
                                    break;
                                    case 23:
                                    return "被拒绝"
                                    break;
                                    case 30:
                                    return "待确认"
                                    break;
                                    case 40:
                                    return "已完成"
                                    break;
                                    case 50:
                                    return "已关闭"
                                    break;
                            }
                            return data;
                        }
                    }//报修状态
                ],
                "oLanguage": {
                    "sLengthMenu": "每页显示 _MENU_ 条记录",
                    "sInfo": "从 _START_ 到 _END_ 页共 _TOTAL_ 条数据",
                    "sInfoEmpty": "没有数据",
                    "sInfoFiltered": "(从 _MAX_ 条数据中检索)",
                    "oPaginate": {
                        "sFirst": "首页",
                        "sPrevious": "前一页",
                        "sNext": "后一页",
                        "sLast": "尾页"
                    },
                    "sZeroRecords": "没有检索到数据",
                    "sProcessing": "请稍等，正在努力加载中....",
                    "sSearch": "输入检索内容"
                },
                "oSearch": { "sSearch": "" },//初始化搜索
                'paging': true,
                'lengthChange': false,
                'searching': true,
                'ordering': true,
                'info': true,
                'autoWidth': false,
                "processing": true,             //是否显示处理状态
                "aLengthMenu": [10, 20, 25, 50]//每页显示多少条数据
            })

        },
        accept: function () {//受理
            var _self = this;
            // swal("功能维护中");
            if (_self.datatable_obj.rows('.selected').data().length > 0) {
                swal({
                    title: "受理?",
                    text: "一旦保存，将开始受理!",
                    icon: "warning",
                    buttons: true,
                    dangerMode: true,
                })
                    .then(function (willDelete) {
                        if (willDelete) {
                            console.log(_self.datatable_obj.row('.selected').data().id)
                            //TODO 添加&修改操作
                            $.ajax({
                                type: 'post',
                                dataType: 'json',
                                contentType: "application/json; charset=utf-8;",
                                xhrFields: {
                                    //设置跨域请求
                                    withCredentials: true
                                },
                                url: jQuery.url + '/task/accept',
                                data: JSON.stringify({
                                    id: _self.datatable_obj.row('.selected').data().id
                                }),
                                headers: {
                                    'token': localStorage.getItem('token')
                                },
                                success: function (data) {
                                    // console.log(data);
                                    if (data.code == 0) {
                                        //刷新列表内容
                                        var currentPage = _self.datatable_obj.page();
                                        console.log(currentPage)
                                        $('#merchant-list').DataTable().destroy();
                                        _self.taskGetList();
                                        _self.initCategoryDataTables();
                                        //显示成功信息
                                        swal("保存成功", {
                                            icon: "success",
                                        });
                                        setTimeout(function () {
                                            _self.datatable_obj.page(currentPage).draw(false);
                                        }, 200);
                                    } else {
                                        swal("关闭失败", data.msg, "error");
                                    }
                                },
                                err: function (err) {
                                    swal("", err, "error");
                                }
                            })
                        } else {
                            swal("没有操作!");
                        }
                    });
            } else {
                _self.FnAlert();
            }
        },
        repaired: function () {//修好
            var _self = this;
            swal("功能维护中");
        },
        track: function () {//跟踪
            var _self = this;
            swal("功能维护中");
        },
        close: function () {//关闭报修单
            var _self = this;
            if (_self.datatable_obj.rows('.selected').data().length > 0) {
                console.log(_self.datatable_obj.rows('.selected').data()[0].id)
                swal({
                    title: "确定要关闭报修单吗?",
                    text: "一旦保存，将不再报修!",
                    icon: "warning",
                    buttons: true,
                    dangerMode: true,
                })
                    .then(function (willDelete) {
                        if (willDelete) {
                            console.log(_self.datatable_obj.row('.selected').data().id)
                            //TODO 添加&修改操作
                            $.ajax({
                                type: 'post',
                                dataType: 'json',
                                contentType: "application/json; charset=utf-8;",
                                xhrFields: {
                                    //设置跨域请求
                                    withCredentials: true
                                },
                                url: jQuery.url + '/task/close',
                                data: JSON.stringify({
                                    ids: _self.datatable_obj.row('.selected').data().id
                                }),
                                headers: {
                                    'token': localStorage.getItem('token'),
                                },
                                complete: function (jqxhr, txt_status) {
                                    if (txt_status == "error" || txt_status == "parsererror") {
                                        console.log(JSON.stringify(jqxhr));
                                        swal("", "服务器请求失败", "error")
                                    }
                                },
                                success: function (data) {
                                    // console.log(data);
                                    if (data.code == 0) {
                                        //刷新列表内容
                                        var currentPage = _self.datatable_obj.page();
                                        console.log(currentPage)
                                        $('#merchant-list').DataTable().destroy();
                                        _self.taskGetList();
                                        _self.initCategoryDataTables();
                                        //显示成功信息
                                        swal("保存成功", {
                                            icon: "success",
                                        });
                                        setTimeout(function () {
                                            _self.datatable_obj.page(currentPage).draw(false);
                                        }, 200);
                                    } else {
                                        swal("关闭失败", data.msg, "error");
                                    }
                                },
                                err: function (err) {
                                    swal("", err, "error");
                                }
                            })
                        } else {
                            swal("没有操作!");
                        }
                    });
            } else {
                _self.FnAlert();
            }

        }
    },
    beforecreate: function (params) {//可以在这加个loading事件，在加载实例时触发
    },
    created: function () {//初始化完成时的事件写在这里，如在这结束loading事件，异步请求也适宜在这里调用

        console.log('created');
        this.equipmentGetList()
        this.orgGetBindList();
    },
    mounted: function () {//: 挂载元素，获取到DOM节点
        console.log('mounted');
        var _self = this;
        // todo 获取报修列表
        _self.taskGetList();
        //select2美化插件
        $('.select2').select2({
            allowClear: true
        });
        //绑定客户选择
        $("#selectCustomer").select2({
            data: $.map(_self.customerList, function (obj) {
                return { id: obj.name, text: obj.name };
            }),
            placeholder: "请选择用户",
            minimumResultsForSearch: 5,//小于5条不显示搜索框
            allowClear: true,
            closeOnSelect: true, //选择完后是否关闭下拉
            disabled: false      //是否不可用
        });
        //绑定设备选择
        $("#selectDevice").select2({
            data: $.map(_self.deviceNameList, function (obj) {
                return { id: obj.name, text: obj.name };
            }),
            placeholder: "请选择设备",
            minimumResultsForSearch: 5,//小于5条不显示搜索框
            allowClear: true,
            closeOnSelect: true, //选择完后是否关闭下拉
            disabled: false      //是否不可用
        });
        //状态列表加载
        $("#selectStatus").select2({
            data: _self.statusList,
            placeholder: "报修状态",
            minimumResultsForSearch: 5,//小于5条不显示搜索框
            allowClear: true,
            closeOnSelect: true, //选择完后是否关闭下拉
            disabled: false      //是否不可用
        });
        $(".select2").val("").trigger("change");//所有.select2初始化不选中
        //筛选框内容变化表格筛选
        $('#selectCustomer').on("change", function () {
            _self.Fnsearch(this.value, 4);
        });
        $('#selectDevice').on("change", function () {
            _self.Fnsearch(this.value, 1);
        });
        $('#selectStatus').on("change", function () {
            _self.Fnsearch(this.value, 6);
        });
        //全局搜索框
        $('input.global_filter').on('keyup click', function () {
            filterGlobal();
        });
        //初始化表格
        _self.initCategoryDataTables();
        //TODO 添加各个表单的提交验证
        $("#addForm").bootstrapValidator({
            fields: {
                description: {
                    validators: {
                        notEmpty: {
                            message: '报修内容必须填写'
                        }
                    }
                },
                equipId: {
                    validators: {
                        notEmpty: {
                            message: '请选择设备名称'
                        }
                    }
                }
            }
        });
        $("#chkForm").bootstrapValidator({
            fields: {
                examineCalibrate: {
                    validators: {
                        notEmpty: {
                            message: '检定情况必须填写'
                        }
                    }
                },
                examineQc: {
                    validators: {
                        notEmpty: {
                            message: '质控情况必须填写'
                        }
                    }
                },
                examineSample: {
                    validators: {
                        notEmpty: {
                            message: '留样情况必须填写'
                        }
                    }
                },
                examineDescription: {
                    validators: {
                        notEmpty: {
                            message: '验收说明必须填写'
                        }
                    }
                },
                malfunctionDuration: {
                    validators: {
                        notEmpty: {
                            message: '故障时长必须填写'
                        }
                    }
                },
            }
        })
        $(function () {
            console.log($)
            //绑定datatable#merchant-list表格点击选中事件
            $('#merchant-list').on('click', 'tbody tr', function () {
                if ($(this).hasClass('selected')) {
                    $(this).removeClass('selected');
                }
                else {
                    _self.datatable_obj.$('tr.selected').removeClass('selected');
                    $(this).addClass('selected');
                }
            });



        })
        //新建适时保养的上传组件只能初始化一次
        $('#modalAdd').on("shown.bs.modal", function () {
            if (_self.uploader == undefined) {
                //上传图片初始化
                _self.FnUploadAttachment();
            } else {
                _self.uploader.reset();
            }
        });

    }
})
var vm = new Vue({
    el: "#myTask",
    data: {
        org: JSON.parse(localStorage.getItem('org')),
        user: JSON.parse(localStorage.getItem('user'))
    }
});



