
var datatable_obj = null;//主表
Vue.component('my-content', {
    template: "#main-template",
    data: function () {
        return {
            org: JSON.parse(localStorage.getItem('org')),
            user: JSON.parse(localStorage.getItem('user')),
            time: 0,
            second: 180,//3分钟间隔
            disabled: false,
            error: {
                msg: '您输入的用户名或密码有误',
                styleObject: {
                    color: 'red',
                    'text-align': 'left',
                    display: 'none'
                }
            },
            form: {
                mobile: "",
                code: "",
                password: "",
                type: 3  //1、平台管理员2、业务员3.普通用户
            }
        }
    },
    methods: {
        makeCode: function () {//生成二维码图片
            var id = JSON.parse(localStorage.getItem('org')).type.id//登录组织主键
            var name = JSON.parse(localStorage.getItem('org')).type.name//登录组织名称
            //根据id生成二维码
            var qrcode = new QRCode(document.getElementById("qrcode"), {
                width: 150,
                height: 150
            });
            //todo
            qrcode.makeCode('http://wx.ailabcare.com/kuaixiu/common/attachment/' + '25');
        },
        start: function () {
            var _self = this;
            var tel = parseFloat($("#mobile").val());//获取手机号码输入框值
            var reg = /^1[3|4|5|8][0-9]\d{8}$/;
            if (!reg.test(tel)) { //校验手机号码格式
                _self.error.msg = "请先输入您的正确手机号";
                _self.error.styleObject.display = 'block';
                return false;
            }
            $.ajax({
                type: 'post',
                url: jQuery.url + '/common/sendSmsCode',
                data: JSON.stringify({ mobile: tel, type: 1 }),
                dataType: 'json',
                contentType: "application/json; charset=utf-8",
                xhrFields: {
                    //设置跨域请求
                    withCredentials: true
                },
                success: function (data) {
                    console.log(data);
                    if (data.code == 0) {
                        _self.disabled = true;
                        _self.time = _self.second;
                        _self.timer();
                        _self.error.msg = "短信发送成功";
                        _self.error.styleObject.color = 'green';
                        _self.error.styleObject.display = 'block';
                    } else if (data.code == 2) {
                        _self.error.msg = data.msg;
                        _self.error.styleObject.color = 'red';
                        _self.error.styleObject.display = 'block';
                    }
                },
                err: function (err) {
                    alert(err);
                }
            })


        },
        timer: function () {
            if (this.time > 0) {
                this.time--;
                setTimeout(this.timer, 1000);
            } else {
                this.disabled = false;
            }
        },
        register: function () {
            var _self = this;
            var bootstrapValidator = $("#login-form").data('bootstrapValidator');
            bootstrapValidator.validate();
            if (bootstrapValidator.isValid()) {
                if ($('#agree').is(':checked')) {
                    $.ajax({
                        type: 'post',
                        url: jQuery.url + '/org/register',
                        data: JSON.stringify(_self.form),
                        dataType: 'json',
                        contentType: "application/json; charset=utf-8",
                        xhrFields: {
                            //设置跨域请求
                            withCredentials: true
                        },
                        success: function (data) {
                            console.log(data)
                            if (data.code == 0) {
                                _self.error.styleObject.display = 'none';
                                location.href = "login.html";
                            } else if (data.code == 2) {
                                _self.error.msg = data.msg;
                                _self.error.styleObject.color = 'red';
                                _self.error.styleObject.display = 'block';
                                $('#login-form').bootstrapValidator('disableSubmitButtons', false);
                            }
                        },
                        error: function (err) {
                            //                                alert(err);
                            $('#login-form').bootstrapValidator('disableSubmitButtons', false);
                        }
                    })

                } else {
                    return false
                }

            } else {
                return
            }
        },
        initCategoryDataTables: function () {// /user/getList 获取用户列表
            $.ajax({
                type: 'post',
                dataType: 'json',
                contentType: "application/json; charset=utf-8;",
                xhrFields: {
                    //设置跨域请求
                    withCredentials: true
                },
                url: jQuery.url + '/user/getList',
                data: JSON.stringify({
                    "orgId": JSON.parse(localStorage.getItem('org')).id,
                    "pageNumber": 0,
                    "pageSize": 100000
                }),
                headers: {
                    'token': localStorage.getItem('token'),
                },
                success: function (data) {
                    console.log(JSON.stringify(data));
                    var Data = data.data;
                    if (data.code == 0) {
                        //绘制表格
                        datatable_obj = $('#merchant-list').DataTable({
                            data: data.data,
                            columns: [
                                { data: 'userName' },//名称
                                { data: 'userName' },//联系电话 暂时相同
                                { data: 'dept' },//部门
                                {
                                    data: 'updateTime',
                                    // render: function (data, type, row) {
                                    //     // If display or filter data is requested, format the date
                                    //     if (type === 'display' || type === 'filter') {
                                    //         var d = new Date(data);
                                    //         return d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate();
                                    //     }
                                    //     // Otherwise the data type requested (`type`) is type detection or
                                    //     // sorting data, for which we want to use the integer, so just return
                                    //     // that, unaltered
                                    //     return data;
                                    // }
                                    render: function (data, type, row) {
                                        if (data != null && data != '') {
                                            return moment(data).format('YYYY-MM-DD');
                                        } else {
                                            return null
                                        }
                                    }
                                },//加入时间
                                {
                                    data: 'userType',
                                    "render": function (data, type, row, meta) {
                                        if (data == 0) {
                                            return '系统管理员'
                                        } else if (data == 1) {
                                            return "平台管理员"
                                        } else if (data == 2) {
                                            return '业务管理员'
                                        } else if (data == 3) {
                                            return "普通用户"
                                        }
                                    }
                                }//用户类型
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
                            "aLengthMenu": [10, 20, 25, 50] //每页显示多少条数据
                        })
                    } else if (data.code == 1) {
                        alert(data.msg);
                        location.href = "../login.html";
                    } else if (data.code == 2) {
                        alert(data.msg);
                    }
                },
                err: function (err) {
                    alert(err);
                }
            })

        },
        invite: function () {//邀请更多小伙伴
            $("#modalInvite").modal({ backdrop: 'static', keyboard: false });
        },
        add: function () {//添加
            document.getElementById("addForm").reset();
            $("#addForm .select2").val("").trigger("change");
            $("#modalAdd").modal({ backdrop: 'static', keyboard: false });
        },
        upd: function () {//修改
            //TODO 数据回填
            if (datatable_obj.rows('.selected').data().length > 0) {
                document.getElementById("addForm").reset();
                $("#addForm .select2").val("").trigger("change");
                $("#addForm .modal-title").html("我的成员-修改");
                var callbackData = datatable_obj.row('.selected').data();
                $('#modalAdd [name="name"]').val(callbackData.userName);
                $("#modalAdd").modal({ backdrop: 'static', keyboard: false });
            } else {
                FnAlert();
            }
        },
        del: function () {//删除
            if (datatable_obj.rows('.selected').data().length > 0) {
                swal({
                    title: "确定要删除吗?",
                    text: "一旦保存，数据将被删除!",
                    icon: "warning",
                    buttons: true,
                    dangerMode: true,
                })
                    .then(function (willDelete) {
                        if (willDelete) {
                            //TODO 添加&修改操作
                            $("#modalAdd").modal('hide');
                            swal("删除成功", {
                                icon: "success",
                            });
                        } else {
                            swal("没有操作!");
                        }
                    });
            } else {
                FnAlert();
            }

        },
        secret: function () {//修改密码
            //TODO 数据回填
            if (datatable_obj.rows('.selected').data().length > 0) {
                document.getElementById("secretForm").reset();
                $("#modalSecret").modal({ backdrop: 'static', keyboard: false });
            } else {
                FnAlert();
            }

        },
        FnAlert: function () {
            swal("操作有误!", "请选择要编辑的数据行!", "error");
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
        FnEditSave: function () {
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
                                "id": _self.org.id,//组织主键 ,
                                "code": $('#addForm [name="code"]').val(),//短信验证码,
                                "mobile": $('#addForm [name="mobile"]').val(),//手机号码 ,
                                "password": $('#addForm [name="password"]').val(),//手机号码
                            };
                            // console.log(postData)
                            //创建/更新计划
                            $.ajax({
                                type: 'post',
                                dataType: 'json',
                                contentType: "application/json; charset=utf-8;",
                                xhrFields: {
                                    //设置跨域请求
                                    withCredentials: true
                                },
                                url: jQuery.url + '/user/register',
                                data: JSON.stringify(postData),
                                headers: {
                                    'token': localStorage.getItem("token"),
                                },
                                success: function (data) {
                                    // console.log(JSON.stringify(data));
                                    if (data.code == 0) {
                                        //刷新列表内容
                                        var currentPage = datatable_obj.page();
                                        // console.log(currentPage)
                                        $('#merchant-list').DataTable().destroy();
                                        _self.initCategoryDataTables();
                                        //关闭弹窗
                                        $("#modalAdd").modal('hide');
                                        //显示成功信息
                                        swal("保存成功", {
                                            icon: "success",
                                        });
                                        setTimeout(function () {
                                            datatable_obj.page(currentPage).draw(false);
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

        FnSecretSave: function () {   //修改密码保存按钮
            swal({
                title: "确定要保存吗?",
                text: "一旦保存，数据将被修改!",
                icon: "warning",
                buttons: true,
                dangerMode: true,
            })
                .then(function (willDelete) {
                    if (willDelete) {
                        //TODO 添加&修改操作
                        $("#modalSecret").modal('hide');
                        swal("保存成功", {
                            icon: "success",
                        });
                    } else {
                        swal("没有操作!");
                    }
                });
        },
        waiting:function () {
            swal("功能维护中")
        }
    },
    computed: {
        text: function () {
            return this.time > 0 ? this.time + 's 后重获取' : '获取验证码';
        },
        isLab: function () {//判断是实验室还是服务商人员
            return loginStyle == 1;
        }
    },
    created: function () {

    },
    mounted: function () {
        //select2美化插件
        $('.select2').select2({
            allowClear: true
        });
        $(".select2").val("").trigger("change");//所有.select2初始化不选中
        //初始化表格
        this.initCategoryDataTables();
        //todo 生成二维码
        this.makeCode();
        //绑定datatable#merchant-list表格点击选中事件
        $('#merchant-list').on('click', 'tbody tr', function () {
            if ($(this).hasClass('selected')) {
                $(this).removeClass('selected');
            }
            else {
                datatable_obj.$('tr.selected').removeClass('selected');
                $(this).addClass('selected');
            }
        });

        $(function () {
            //TODO 添加各个表单的提交验证
            $("#addForm").bootstrapValidator({
                fields: {
                    code: {
                        validators: {
                            notEmpty: {
                                message: '验证码必须填写'
                            }
                        }
                    },
                    mobile: {//手机号
                        validators: {
                            notEmpty: {
                                message: '手机号必须填写'
                            }
                        }
                    },
                    password: {//密码
                        validators: {
                            notEmpty: {
                                message: '设置密码必须填写'
                            }
                        }
                    },
                    departArea: {//
                        validators: {
                            notEmpty: {
                                message: '科室必须填写'
                            }
                        }
                    },
                    style: {//
                        validators: {
                            notEmpty: {
                                message: '用户类型必须填写'
                            }
                        }
                    }
                }
            })

        });

    }
})
var vm = new Vue({
    el: "#remembers",
    data: {
        org: JSON.parse(localStorage.getItem('org')),
        user: JSON.parse(localStorage.getItem('user'))
    },
    mounted: function () {

    }
})