Vue.component('my-content',{
    template: "#main-template",
    data:function () {
	return {
        org: JSON.parse(localStorage.getItem('org')),
        user: JSON.parse(localStorage.getItem('user')),
        datatable_obj: null,
        loginStyle: loginStyle,
        deviceNameList: [],//设备列表
        planList: [],//计划列表
        editKind: true//true新增 false修改
    }
    },
    computed: {
        isLab: function () {//判断是实验室还是服务商人员
            return loginStyle == 1;
        }
    },
    watch: {},
    methods: {
        planGetList: function () {
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
                url: jQuery.url + '/plan/getList',
                data: JSON.stringify({  
                    "pageNumber": 0,
                    "pageSize": 1000,
                    "type": 1
                }),
                headers: {
                    'token': localStorage.getItem('token'),
                },
                success: function (data) {
                    console.log(JSON.stringify(data));
                    if (data.code == 0) {
                        _self.planList = data.data;
                    }
                },
                err: function (err) {
                    swal("", err, "error")
                }
            });
        },
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
        FnEditSave: function () {//新增or修改计划保存按钮
            var _self = this;
            $("#addForm").data("bootstrapValidator").resetForm();//重置表单验证
            var bootstrapValidator = $("#addForm").data('bootstrapValidator');
            bootstrapValidator.validate();
            if (bootstrapValidator.isValid()) {
                swal({
                    title: "确定要保存吗?",
                    text: "一旦保存，数据将被修改!",
                    icon: "warning",
                    buttons: true,
                    dangerMode: true,
                })
                    .then(function (willDelete) {
                        if (willDelete) {
                            var postData = {
                                "id": _self.editKind ? "" : _self.datatable_obj.row('.selected').data().id,//保养计划主键
                                "name": $('#addForm [name="name"]').val(),//计划名称,
                                "content": $('#addForm [name="content"]').val(),//计划内容
                                "equipId": parseInt($('#addForm [name="equipId"]').val()),//设备主键
                                "periodType": parseInt($('#addForm [name="periodType"]').val()),//计划类型  
                                "startTime": $('#addForm [name="startTime"]').val(),//"2018-01-12T07:55:02.995Z",
                                "executePermission": _self.isLab ? parseInt($('#addForm [name="executePermission"]').val()):1,//执行权限
                                "type": 1//1保养计划 2检定计划
                            };
                            console.log(postData)
                            //创建/更新计划
                            $.ajax({
                                type: 'post',
                                dataType: 'json',
                                contentType: "application/json; charset=utf-8;",
                                xhrFields: {
                                    //设置跨域请求
                                    withCredentials: true
                                },
                                url: jQuery.url + '/plan/save',
                                data: JSON.stringify(postData),
                                headers: {
                                    'token': localStorage.getItem("token"),
                                },
                                success: function (data) {
                                    console.log(JSON.stringify(data));
                                    if (data.code == 0) {
                                        //刷新列表内容
                                        var currentPage = _self.datatable_obj.page();
                                        console.log(currentPage)
                                        $('#merchant-list').DataTable().destroy();
                                        _self.planGetList();
                                        _self.initCategoryDataTables();
                                        //关闭弹窗
                                        $("#modalAdd").modal('hide');
                                        //显示成功信息
                                        swal("保存成功", {
                                            icon: "success",
                                        });
                                        setTimeout(function () {
                                            _self.datatable_obj.page(currentPage).draw(false);
                                        }, 200);
                                    } else {
                                        swal("", data.msg, "error")
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
                console.log('表单验证失败');
            }
        },
        initCategoryDataTables: function () {
            var _self = this;
            //绘制表格
            _self.datatable_obj = $('#merchant-list').DataTable({
                data: this.planList,
                // data:[],
                columns: [
                    { data: 'name' },//计划名称
                    {
                        data: 'startTime',
                        render: function (data, type, row) {
                            return moment(data).format('YYYY-MM-DD');
                        }
                    },//计划开始时间
                    {
                        data: 'equipId',
                        "render": function (data, type, row, meta) {
                            for (var i = 0; i < _self.deviceNameList.length; i++) {
                                if (data == _self.deviceNameList[i].id){
                                    return _self.deviceNameList[i].name
                                }
                            }
                            return ""
                        }
                    },//设备名称，此处暂时未设备主键
                    {
                        data: 'periodType',
                        "render": function (data, type, row, meta) {
                            if (data == 0) {
                                return ""
                            } else if (data == 1) {
                                return "每日保养"
                            } else if (data == 2) {
                                return '每周保养'
                            } else if (data == 3) {
                                return "每月保养"
                            } else if (data == 4) {
                                return "每三月保养"
                            } else if (data == 5) {
                                return "每半年保养"
                            } else if (data == 6) {
                                return "每年保养"
                            } else {
                                return ""
                            }
                        }
                    },// 周期类型 1、每日 2、每周 3、每月 4、每3月 5、每半年 6、每年  
                    { data: 'executeCount' },//执行次数
                    {
                        data: 'latestExecuteTime',//最近执行时间 
                        render: function (data, type, row) {
                            if(data!=null && data!=''){
                                return moment(data).format('YYYY-MM-DD');
                            }else{
                                return null
                            }
                        }
                    }
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
                "aLengthMenu": [10, 20, 25, 50],  //每页显示多少条数据
            })

        },
        add: function () {//新增计划
            this.editKind = true;
            document.getElementById("addForm").reset();
            $("#addForm .select2").val("").trigger("change");
            $("#addForm .modal-title").html("保养计划-添加");
            $("#addForm").data("bootstrapValidator").resetForm();//重置表单验证
            $("#modalAdd").modal({ backdrop: 'static', keyboard: false });
        },
        upd: function () {//修改计划
            var _self = this;
            //数据回填
            if (_self.datatable_obj.rows('.selected').data().length > 0) {
                this.editKind = false;
                document.getElementById("addForm").reset();
                $("#addForm .select2").val("").trigger("change");
                $("#addForm .modal-title").html("保养计划-修改");
                $("#addForm").data("bootstrapValidator").resetForm();//重置表单验证
                var callbackData = this.datatable_obj.row('.selected').data();
                console.log(callbackData);
                $('#addForm [name="name"]').val(callbackData.name);
                $('#addForm [name="content"]').val(callbackData.content);
                $('[name="equipId"]').select2('val',[callbackData.equipId]);
                $('[name="periodType"]').select2('val',[callbackData.periodType]);
                if(_self.isLab){
                    $('[name="executePermission"]').select2('val',''+callbackData.executePermission);
                }
                // $('#addForm [name="startTime"]').val(callbackData.startTime);
                console.log(callbackData.startTime);
                $('#addForm [name="startTime"]').datepicker("setDate", crtTimeFtt(callbackData.startTime));//设置
                $("#modalAdd").modal({ backdrop: 'static', keyboard: false });
            } else {
                this.FnAlert();
            }
        },
        del: function () {//删除计划
            var _self = this;
            if (_self.datatable_obj.rows('.selected').data().length > 0) {
                swal({
                    title: "确定要删除计划吗?",
                    text: "一旦删除，将不能找回!",
                    icon: "warning",
                    buttons: true,
                    dangerMode: true,
                })
                    .then(function (willDelete) {
                        if (willDelete) {
                            console.log(_self.datatable_obj.row('.selected').data().id);
                            $.ajax({
                                type: 'post',
                                dataType: 'json',
                                contentType: "application/json; charset=utf-8;",
                                xhrFields: {
                                    //设置跨域请求
                                    withCredentials: true
                                },
                                url: jQuery.url + '/plan/delete',
                                data: JSON.stringify({
                                    id: _self.datatable_obj.row('.selected').data().id
                                }),
                                headers: {
                                    'token': localStorage.getItem('token'),
                                },
                                success: function (data) {
                                    console.log(data);
                                    // 删除功能数据库没有实现
                                    if (data.code == 0) {
                                        _self.datatable_obj.row('.selected').remove().draw();
                                        swal("删除成功", {
                                            icon: "success",
                                        });
                                    } else {
                                        swal("", data.msg, "error")
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
                this.FnAlert();
            }

        }
    },
    beforecreate: function (params) {//可以在这加个loading事件，在加载实例时触发

    },
    created: function () {//初始化完成时的事件写在这里，如在这结束loading事件，异步请求也适宜在这里调用
         
        console.log('created');
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
        })

    },
    mounted: function () {//: 挂载元素，获取到DOM节点
        console.log('mounted');
        var _self = this;
        //获取计划列表
        _self.planGetList();
        //Date picker;
        $('.datepicker').datepicker({
            language: "zh-CN",
            autoclose: true,//选中之后自动隐藏日期选择框
            format: "yyyy-mm-dd"//日期格式
        });
        //select2美化插件
        $('.select2').select2({
            allowClear: true
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
        $(".select2").val("").trigger("change");//所有.select2初始化不选中
        //筛选框内容变化表格筛选
        $('#selectDevice').on("change", function () {
            _self.Fnsearch(this.value, 2);
        });
        //全局搜索框
        $('input.global_filter').on('keyup click', function () {
            _self.filterGlobal();
        });
        //初始化表格
        _self.initCategoryDataTables();
        //TODO 绑定新增弹窗的选择计划类型的事件，根据选择类型初始化开始日期组件

        // 添加各个表单的提交验证
        $("#addForm").bootstrapValidator({
            submitHandler: function (valiadtor, loginForm, submitButton) {
                $('#addForm').bootstrapValidator('disableSubmitButtons', false);
            },
            fields: {
                name: {
                    validators: {
                        notEmpty: {
                            message: '计划名称必须填写'
                        }
                    }
                },
                content: {
                    validators: {
                        notEmpty: {
                            message: '内容必须填写'
                        }
                    }
                },
                executePermission: {
                    validators: {
                        notEmpty: {
                            message: '执行权限必须填写'
                        }
                    }
                },
                equipId: {
                    validators: {
                        notEmpty: {
                            message: '请选择设备名称'
                        }
                    }
                },
                periodType: {
                    validators: {
                        notEmpty: {
                            message: '请选择保养类型'
                        }
                    }
                },
                startTime: {
                    validators: {
                        notEmpty: {
                            message: '请选择开始时间'
                        }
                    }
                }
            }
        })
        $(function () {
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

    }
})
//服务商和实验室在保养计划流程的区别在于实验室多一个判断执行权限，位于新增修改计划弹窗中
var vm = new Vue({
    el: "#maintenancePlan",
    data: {
        org: JSON.parse(localStorage.getItem('org')),
        user: JSON.parse(localStorage.getItem('user'))
    }
});
