Vue.component('my-content', {
    template: "#main-template",
    data: function () {
        return {
            org: JSON.parse(localStorage.getItem('org')),
            user: JSON.parse(localStorage.getItem('user')),
            datatable_obj: null,//主表
            loginStyle: "",
            bindBtn: "绑定按钮",
            selectProvideData: [],
            custmerOrproviderSelData: [],
            keyName: "",//绑定组织的主键是providerName还是labName
            firstCheck: true,//是否有是第一次提交验收记录
            checkFormId: "",//设备验收主键默认为空
            reference: "",//验收依据
            conclusion: "",//验收结论
            status: 0,//是否归档，0草稿，1归档
            checkFormList: [],
            checkFormAddList: []
        }
    },
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
            var _self =this;
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
        FnAddRecord: function () {
            var _self =this;
            //验收-新增一条记录
            this.checkFormAddList.push({
                id: "",
                examineId: "",
                name: "",
                unit: "",
                standardValue: "",
                measureValue: "",
                deviationValue: "",
                isQualified: "0",
                remark: "",
                disabled: false//验收表中记录是否归档，归档后不可修改
            })
        },
        FnChkArchive: function () {//验收归档
            var _self =this;
            swal({
                title: "确定要归档吗?",
                text: "一旦归档，数据不能被修改!",
                icon: "warning",
                buttons: true,
                dangerMode: true,
            })
                .then(function (willDelete) {
                    if (willDelete) {
                        // console.log(_self.datatable_obj.row('.selected').data().id);
                        $.ajax({
                            type: 'post',
                            dataType: 'json',
                            contentType: "application/json; charset=utf-8;",
                            xhrFields: {
                                //设置跨域请求
                                withCredentials: true
                            },
                            url: jQuery.url + '/equipment/archiveExamine',
                            data: JSON.stringify({
                                equipId: _self.datatable_obj.row('.selected').data().id,//设备主键id
                                id: _self.checkFormId,//设备验收主键 
                                reference: _self.reference,//验收依据
                                conclusion: _self.conclusion,//验收结论
                                // examineTime:"",//验收日期yyyy-mm-dd,
                                examineItems: _self.checkFormList
                            }),
                            headers: {
                                'token': localStorage.getItem('token'),
                            },
                            success: function (data) {
                                // console.log(data);
                                // 归档逻辑
                                if (data.code == 0) {
                                    $("#modalChk").modal("hide");
                                    swal("归档成功", {
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

        },

        FnEditSave: function () {//添加*修改保存按钮
            var _self =this;
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
                            //验证成功创建设备
                            var postData = {
                                "code": $('#addForm [name="code"]').val(),//设备编码
                                "name": $('#addForm [name="name"]').val(),//设备名称
                                "model": $('#addForm [name="model"]').val(),//设备型号
                                "usedDept": $('#addForm [name="usedDept"]').val(),//设备使用部门
                                "manufacturer": $('#addForm [name="manufacturer"]').val(),//制造商
                                "madeArea": $('#addForm [name="madeArea"]').val(),//产地
                                "manufacturerContact": $('#addForm [name="manufacturerContact"]').val(),//制造商联系人
                                "manufacturerTelephone": $('#addForm [name="manufacturerTelephone"]').val(),//制造商联系电话
                                "supplier": $('#addForm [name="supplier"]').val(),//供应商
                                "supplierContact": $('#addForm [name="supplierContact"]').val(),//供应商联系人
                                "supplierTelephone": $('#addForm [name="supplierTelephone"]').val(),//供应商联系电话
                                "madeTime": $('#addForm [name="madeTime"]').val(),//出厂日期
                                "madeNo": $('#addForm [name="madeNo"]').val(),//出厂编号
                                "usedTime": $('#addForm [name="usedTime"]').val(),//启用日期
                                "purchasedTime": $('#addForm [name="purchasedTime"]').val(),//购买日期
                                "checkPeriod": $('#addForm [name="checkPeriod"]').val(),//鉴定周期
                                "place": $('#addForm [name="place"]').val(),//安装位置
                                "owner": $('#addForm [name="owner"]').val(),//责任人
                                "checkPermission": $('#addForm [name="checkPermission"]').val(),//鉴定权限
                                "id": $('#addForm [name="id"]').val()//主键
                                // "createUser": 0,// 创建用户
                                // "orgId": 0,//组织主键 ,
                                // "userType": 2//用户类型0、系统管理员 1、平台管理员，一个平台只有一个 2、业务管理员，一个平台可以有多个 3、普通用户
                            };
                            // console.log(postData);
                            $.ajax({
                                type: 'post',
                                dataType: 'json',
                                contentType: "application/json; charset=utf-8;",
                                xhrFields: {
                                    //设置跨域请求
                                    withCredentials: true
                                },
                                url: jQuery.url + '/equipment/save',
                                data: JSON.stringify(postData),
                                headers: {
                                    'token': localStorage.getItem("token"),
                                },
                                success: function (data) {
                                    // console.log(JSON.stringify(data));
                                    if (data.code == 0) {
                                        //刷新列表内容
                                        var currentPage = _self.datatable_obj.page();
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
                // console.log('表单验证失败');
            }
        },
        FnBindSave: function () {
            var _self =this;
            //绑定服务商保存按钮
            swal({
                title: "确定要保存吗?",
                text: "一旦保存，数据将被修改!",
                icon: "warning",
                buttons: true,
                dangerMode: true,
            })
                .then(function (willDelete) {
                    if (willDelete) {
                        // console.log(_self.datatable_obj.row('.selected').data())
                        //Implementation Notes绑定关联组织
                        $.ajax({
                            type: 'post',
                            dataType: 'json',
                            contentType: "application/json; charset=utf-8;",
                            xhrFields: {
                                //设置跨域请求
                                withCredentials: true
                            },
                            url: jQuery.url + '/equipment/bindOrg',
                            data: JSON.stringify({
                                "id": parseInt(_self.datatable_obj.row('.selected').data().id),//设备主键 ,
                                "relatedOrgId": parseInt($("#custmerOrproviderSel").val())//关联组织主键
                            }),
                            headers: {
                                'token': localStorage.getItem('token'),
                            },
                            success: function (data) {
                                // console.log(data)
                                if (data.code == 0) {
                                    //刷新列表内容
                                    var currentPage = _self.datatable_obj.page();
                                    $('#merchant-list').DataTable().destroy();
                                    _self.initCategoryDataTables();
                                    //关闭弹窗
                                    $("#modalBind").modal('hide');
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
                        swal("保存成功", {
                            icon: "success",
                        });
                    } else {
                        swal("没有操作!");
                    }
                });
        },

        FnChkSubmit: function () {
            var _self =this;
            //验收记录新增提交--提交前验证内容填写完整
            if (_self.firstCheck) {

                var checkInputs = $("#chkForm .checkFormAddList .form-control");
                if (checkInputs.length == 0) {
                    swal("没有新增记录", "", "error");
                    return false
                }

                //有新增记录且填写完整
                for (var i = 0; i < checkInputs.length; i++) {
                    // console.log(checkInputs[i].value)
                    if (checkInputs[i].value.trim() == "") {
                        swal("请检查数据是否填写完整,所有行不能为空", "", "error");
                        return false
                    }
                }
            }
            $.ajax({
                type: 'post',
                dataType: 'json',
                contentType: "application/json; charset=utf-8;",
                xhrFields: {
                    //设置跨域请求
                    withCredentials: true
                },
                url: jQuery.url + '/equipment/saveExamine',//获取设备验收列表
                data: JSON.stringify({
                    equipId: _self.datatable_obj.row('.selected').data().id,//设备主键id
                    id: _self.checkFormId,//设备验收主键 
                    reference: _self.reference,//验收依据
                    conclusion: _self.conclusion,//验收结论
                    // examineTime:"",//验收日期yyyy-mm-dd
                    examineItems: _self.checkFormAddList//验收项目列表  传递时转成json数组字符串
                }),
                headers: {
                    'token': localStorage.getItem('token'),
                },
                success: function (data) {
                    // console.log(data);  
                    if (data.code == 0) {
                        //关闭弹窗
                        $("#modalChk").modal('hide');
                        swal("", "保存成功", "success")
                    } else {
                        swal("", data.msg, "error")
                    }
                },
                err: function (err) {
                    alert(err);
                }
            });

        },
        initCategoryDataTables: function () {
            var _self = this;
            $.ajax({
                type: 'post',
                dataType: 'json',
                contentType: "application/json; charset=utf-8;",
                xhrFields: {
                    //设置跨域请求
                    withCredentials: true
                },
                url: jQuery.url + '/equipment/getList',
                data: JSON.stringify({
                    // "code": "",//设备编号
                    // "name": "",// 设备名称
                    "pageNumber": 0,
                    "pageSize": 10000,
                    // "status": "",//: 不传值：全部 0：未启用 1：启用
                    // "labId": "",//实验室主键
                    // "providerId": "",//服务商主键  如果当前用户是实验室，只想查询某服务商的，就用providerid限定下
                    // "own": 0//: 是否只查询自己维护的null或0：所有的 1：自己的 ,自己维护的是只所在组织维护的，不包含关联组织维护的
                }),
                headers: {
                    'token': localStorage.getItem('token'),
                },
                success: function (data) {
                    // console.log(JSON.stringify(data));
                    var Data = data.data;
                    if (data.code == 0) {
                        _self.datatable_obj = $('#merchant-list').DataTable({
                            data: data.data,
                            columns: [
                                { data: 'code' },
                                { data: 'name' },
                                { data: 'model' },
                                { data: _self.keyName },//实验室,服务商名称
                                { data: 'usedDept' },
                                { data: 'manufacturer' },
                                { data: 'madeArea' },
                                { data: 'manufacturerContact', "width": "80" }
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
                            "aLengthMenu": [10, 20, 25, 50]  //每页显示多少条数据
                        });
                    }
                },
                err: function (err) {
                    swal("", err, "error");
                }
            })
        },
        add: function () {
            var _self = this;
            //新增时使用reset初始化数据，并清空select2插件
            document.getElementById("addForm").reset();
            $("#addForm .select2").val("").trigger("change");
            $("#addForm .modal-title").html("我的设备-添加");
            $("#modalAdd").modal({ backdrop: 'static', keyboard: false });
        },
        upd: function () {
            var _self = this;
            // 数据回填
            if (_self.datatable_obj.rows('.selected').data().length > 0) {
                document.getElementById("addForm").reset();
                $("#addForm .select2").val("").trigger("change");
                $("#addForm .modal-title").html("我的设备-修改");
                console.log(_self.datatable_obj.row('.selected').data());
                for (var i = 0; i < $("#addForm .form-control").length; i++) {
                    // console.log($("#addForm .form-control:eq("+i+")").attr("name"));
                    $("#addForm [name='" + $("#addForm .form-control:eq(" + i + ")").attr("name") + "']").val(_self.datatable_obj.row('.selected').data()[$("#addForm .form-control:eq(" + i + ")").attr("name")])
                }
                var data =_self.datatable_obj.row('.selected').data()
                console.log(data)
                $('#addForm [name="usedDept"]').select2('val',[data.usedDept]);
                $('#addForm [name="checkPermission"]').select2('val',[data.checkPermission]);
                $('#addForm [name="madeTime"]').datepicker("setDate", crtTimeFtt(data.madeTime));//设置
                $('#addForm [name="usedTime"]').datepicker("setDate", crtTimeFtt(data.usedTime));//设置
                $('#addForm [name="purchasedTime"]').datepicker("setDate", crtTimeFtt(data.purchasedTime));//设置
                $("#modalAdd").modal({ backdrop: 'static', keyboard: false });
            } else {
                _self.FnAlert();
            }

        },
        del: function () {
            var _self = this;
            if (_self.datatable_obj.rows('.selected').data().length > 0) {
                swal({
                    title: "确定要删除吗?",
                    text: "一旦保存，数据将被删除!",
                    icon: "warning",
                    buttons: true,
                    dangerMode: true,
                })
                    .then(function (willDelete) {
                        if (willDelete) {
                            // console.log(_self.datatable_obj.row('.selected').data().id);
                            $.ajax({
                                type: 'post',
                                dataType: 'json',
                                contentType: "application/json; charset=utf-8;",
                                xhrFields: {
                                    //设置跨域请求
                                    withCredentials: true
                                },
                                url: jQuery.url + '/equipment/delete',
                                data: JSON.stringify({
                                    id: _self.datatable_obj.row('.selected').data().id
                                }),
                                headers: {
                                    'token': localStorage.getItem('token'),
                                },
                                success: function (data) {
                                    // console.log(data);
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
                _self.FnAlert();
            }

        },
        bind: function () {
            var _self = this;
            if (_self.datatable_obj.rows('.selected').data().length > 0) {
                document.getElementById("bindForm").reset();
                $("#bindForm .select2").val("").trigger("change");
                $("#modalBind").modal({ backdrop: 'static', keyboard: false });
            } else {
                _self.FnAlert();
            }
        },
        check: function () {
            var _self = this;
            if (_self.datatable_obj.rows('.selected').data().length > 0) {
                // $("#checkRecord tbody").html("");//首先清空操作记录
                _self.checkFormId = "";//清空验收主键
                _self.reference = "";//清空验收依据
                _self.conclusion = "";//清空验收结论
                _self.status = 0;//初始化归档状态
                _self.checkFormList = [];
                _self.checkFormAddList = [];
                _self.firstCheck = true;
                //获取完整的验收记录列表--用于得到验收记录主键
                $.ajax({
                    type: 'post',
                    dataType: 'json',
                    contentType: "application/json; charset=utf-8;",
                    xhrFields: {
                        //设置跨域请求
                        withCredentials: true
                    },
                    url: jQuery.url + '/equipment/getExamineList',
                    data: JSON.stringify({
                        id: _self.datatable_obj.row('.selected').data().id
                    }),
                    headers: {
                        'token': localStorage.getItem('token'),
                    },
                    success: function (data) {
                        // console.log(JSON.stringify(data));
                        if (data.code == 0) {
                            if (data.data != null && data.data != "") {//有且只有一条验收记录
                                // console.log('归档：'+data.data[0].status);
                                _self.status = data.data[0].status;
                                _self.checkFormId = data.data[0].id;
                                _self.reference = data.data[0].reference;
                                _self.conclusion = data.data[0].conclusion;
                                _self.firstCheck = false;
                                $.ajax({
                                    type: 'post',
                                    dataType: 'json',
                                    contentType: "application/json; charset=utf-8;",
                                    xhrFields: {
                                        //设置跨域请求
                                        withCredentials: true
                                    },
                                    url: jQuery.url + '/equipment/getExamine',
                                    data: JSON.stringify({
                                        id: data.data[0].id//设备验收主键
                                    }),
                                    headers: {
                                        'token': localStorage.getItem('token'),
                                    },
                                    success: function (response) {
                                        if (response.code == 0) {
                                            // console.log(JSON.stringify(response))
                                            //如果一次验收时提交多次记录则会返回多条信息
                                            if (response.data != null && response.data !== "") {
                                                for (var i = 0; i < response.data.length; i++) {
                                                    _self.checkFormList.push({
                                                        id: response.data[i].id,
                                                        examineId: response.data[i].examineId,
                                                        name: response.data[i].name,
                                                        unit: response.data[i].unit,
                                                        standardValue: response.data[i].standardValue,
                                                        measureValue: response.data[i].measureValue,
                                                        deviationValue: response.data[i].deviationValue,
                                                        isQualified: response.data[i].isQualified,
                                                        remark: response.data[i].remark,
                                                        disabled: false//验收表中记录是否归档，归档后不可修改
                                                    });
                                                }
                                            }
                                        } else {
                                            swal("提示!", "暂时没有验收信息!", "error");
                                        }
                                        //打开模态框-验收记录
                                        $("#modalChk").modal({ backdrop: 'static', keyboard: false });
                                    },
                                    err: function (err) {
                                        swal("", err, "error");
                                    }
                                })
                            }
                        } else {

                            swal("提示!", "暂时没有验收信息!", "error");
                        }
                        //打开模态框-验收记录
                        $("#modalChk").modal({ backdrop: 'static', keyboard: false });
                    },
                    err: function (err) {
                        swal("", err, "error");
                    }
                })
            } else {
                _self.FnAlert();
            }
        },
        removeTodo: function (index) {//新增的记录删除功能
            this.checkFormAddList.splice(index, 1);
        },
        editTodo: function (index) {
            var _self = this;
            if (_self.checkFormList[index].id !== "" &&
                _self.checkFormList[index].examineId !== "" &&
                _self.checkFormList[index].name.trim() !== "" &&
                _self.checkFormList[index].unit.trim() !== "" &&
                _self.checkFormList[index].standardValue.trim() !== "" &&
                _self.checkFormList[index].measureValue.trim() !== "" &&
                _self.checkFormList[index].deviationValue.trim() !== "" &&
                _self.checkFormList[index].isQualified !== "" &&
                _self.checkFormList[index].remark.trim() !== ""
            ) {
                // for(var i=0;i<_self.checkFormAddList.length;i++){
                $.ajax({
                    type: 'post',
                    dataType: 'json',
                    contentType: "application/json; charset=utf-8;",
                    xhrFields: {
                        //设置跨域请求
                        withCredentials: true
                    },
                    url: jQuery.url + '/equipment/saveExamine',//获取设备验收列表
                    data: JSON.stringify({
                        equipId: _self.datatable_obj.row('.selected').data().id,//设备主键id
                        id: parseInt(_self.checkFormList[index].examineId),//设备验收主键 
                        reference: _self.reference,//验收依据
                        conclusion: _self.conclusion,//验收结论
                        // examineTime:"",//验收日期yyyy-mm-dd
                        examineItems: [_self.checkFormList[index]]//验收项目记录列表  传递时转成json数组字符串
                    }),
                    headers: {
                        'token': localStorage.getItem('token'),
                    },
                    success: function (data) {
                        // console.log(data);
                        if (data.code == 0) {
                            //关闭弹窗
                            swal("", "修改成功", "success")
                        } else {
                            swal("", "修改失败", "error")
                        }
                    },
                    err: function (err) {
                        alert(err);
                    }
                });
            } else {
                swal("请检查数据是否填写完整,所有行不能为空", "", "error");
            }
        },
        deleteTodo: function (index) {
            var _self = this;
            $.ajax({
                type: 'post',
                dataType: 'json',
                contentType: "application/json; charset=utf-8;",
                xhrFields: {
                    //设置跨域请求
                    withCredentials: true
                },
                url: jQuery.url + '/equipment/deleteExamineItem',//删除设备验收项目
                data: JSON.stringify({
                    id: _self.checkFormList[index].id//设备验收项目主键
                }),
                headers: {
                    'token': localStorage.getItem('token'),
                },
                success: function (data) {
                    // console.log(data);
                    if (data.code == 0) {
                        //页面上删除
                        _self.checkFormList.splice(index, 1);
                        //关闭弹窗
                        swal("", "删除成功", "success")
                    } else {
                        swal("", "删除失败", "error")
                    }
                },
                err: function (err) {
                    swal("", err, "error")
                }
            });
        }
    },
    created: function () {
        var _self = this;
        this.loginStyle = JSON.parse(localStorage.getItem('org')).type;
        if (this.loginStyle == 1) {//实验室
            this.bindBtn = "服务商";
            this.keyName = "providerName"
        } else if (this.loginStyle == 2) {//服务商
            this.bindBtn = "客户";
            this.keyName = "labName"
        }
    },

    mounted: function () {
        var _self = this;
        //获取绑定组织列表 用于初始化筛选框 和绑定服务商(客户)列表
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
                "name": "",
                "pageNumber": 0,
                "pageSize": 1000
            }),
            headers: {
                'token': localStorage.getItem('token'),
            },
            success: function (data) {
                // console.log(data);
                if (data.code == 0) {
                    // console.log(data.data);
                    //绑定筛选框
                    _self.selectProvideData = $.map(data.data, function (obj) {
                        return { id: obj.name, text: obj.name };
                    });
                    _self.custmerOrproviderSelData = $.map(data.data, function (obj) {
                        return { id: obj.id, text: obj.name };
                    });
                }
                //Date picker;
                $('.datepicker').datepicker({
                    language: "zh-CN",
                    autoclose: true,//选中之后自动隐藏日期选择框
                    format: "yyyy-mm-dd"//日期格式
                });
                //select2美化插件
                $(".select2").select2({ allowClear: true });
                $(".select2").val("").trigger("change");//所有.select2初始化不选中
                //绑定弹窗内容修改
                $("#custmerOrproviderSel").select2({
                    data: _self.custmerOrproviderSelData,
                    placeholder: "请选择" + _self.bindBtn,
                    minimumResultsForSearch: 5,//小于5条不显示搜索框
                    allowClear: true,
                    closeOnSelect: true, //选择完后是否关闭下拉
                    disabled: false      //是否不可用
                });
                //设备表格筛选插件初始化
                $('#selectProvide').select2({
                    data: _self.selectProvideData,
                    placeholder: "请选择" + _self.bindBtn,
                    minimumResultsForSearch: 5,//小于5条不显示搜索框
                    allowClear: true,
                    closeOnSelect: true, //选择完后是否关闭下拉
                    disabled: false     //是否不可用
                })
                //初始化默认筛选值
                $('#selectProvide').val('').change()
                //筛选框内容变化表格筛选
                $('#selectProvide').on("change", function () {
                    _self.Fnsearch(this.value, 3);
                });
                //全局搜索框
                $('input.global_filter').on('keyup click', function () {
                    _self.filterGlobal();
                });
                //初始化表格
                _self.initCategoryDataTables();
                //绑定datatable#merchant-list表格点击选中事件
                $(document).on('click', '#merchant-list tbody tr', function () {
                    if ($(this).hasClass('selected')) {
                        $(this).removeClass('selected');
                    }
                    else {
                        _self.datatable_obj.$('tr.selected').removeClass('selected');
                        $(this).addClass('selected');
                    }
                });
            },
            err: function (err) {
                swal("", err, "error")
            }
        })

    }

})
var vm = new Vue({
    el: "#device",
    data: {
        org: JSON.parse(localStorage.getItem('org')),
        user: JSON.parse(localStorage.getItem('user')),
        datatable_obj: null,//主表
        loginStyle: "",
        bindBtn: "绑定按钮",
        selectProvideData: [],
        custmerOrproviderSelData: [],
        keyName: "",//绑定组织的主键是providerName还是labName
        firstCheck: true,//是否有是第一次提交验收记录
        checkFormId: "",//设备验收主键默认为空
        reference: "",//验收依据
        conclusion: "",//验收结论
        status: 0,//是否归档，0草稿，1归档
        checkFormList: [],
        checkFormAddList: []
    },
    mounted: function () {
        // console.log(this.$refs)
    }
});






//Modal验证销毁重构
$('#modalAdd').on('hidden.bs.modal', function () {
    $("#addForm").data("bootstrapValidator").resetForm();//重置表单验证
});
$(function () {
    $("#addForm").bootstrapValidator({
        submitHandler: function (valiadtor, loginForm, submitButton) {
            $('#addForm').bootstrapValidator('disableSubmitButtons', false);
        },
        fields: {
            code: {
                validators: {
                    notEmpty: {
                        message: '编码必须填写'
                    }
                }
            },
            name: {
                validators: {
                    notEmpty: {
                        message: '设备名称必须填写'
                    }
                }
            },
            // model: {
            //     validators: {
            //         notEmpty: {
            //             message: '设备型号必须填写'
            //         }
            //     }
            // },
            // usedDept: {
            //     validators: {
            //         notEmpty: {
            //             message: '设备使用部门'
            //         }
            //     }
            // },
            // manufacturer: {
            //     validators: {
            //         notEmpty: {
            //             message: '制造商必须填写'
            //         }
            //     }
            // },
            // madeArea: {
            //     validators: {
            //         notEmpty: {
            //             message: '产地必须填写'
            //         }
            //     }
            // },
            // manufacturerContact: {
            //     validators: {
            //         notEmpty: {
            //             message: '制造商联系人必须填写'
            //         }
            //     }
            // },
            // manufacturerTelephone: {
            //     message: '请输入正确的11位手机号码',
            //     validators: {
            //         notEmpty: {
            //             message: '手机号必须填写'
            //         },
            //         regexp: {
            //             regexp: /^1[3|5|8]{1}[0-9]{9}$/
            //         }
            //     }
            // },
            // supplier: {
            //     validators: {
            //         notEmpty: {
            //             message: '供应商必须填写'
            //         }
            //     }
            // },
            // supplierContact: {
            //     validators: {
            //         notEmpty: {
            //             message: '供应商联系人必须填写'
            //         }
            //     }
            // },
            // supplierTelephone: {
            //     message: '请输入正确的11位手机号码',
            //     validators: {
            //         notEmpty: {
            //             message: '手机号必须填写'
            //         },
            //         regexp: {
            //             regexp: /^1[3|5|8]{1}[0-9]{9}$/
            //         }
            //     }
            // },
            // madeTime: {
            //     validators: {
            //         notEmpty: {
            //             message: '出厂日期必须填写'
            //         }
            //     }
            // },
            // madeNo: {
            //     validators: {
            //         notEmpty: {
            //             message: '出厂编号必须填写'
            //         }
            //     }
            // },
            // usedTime: {
            //     validators: {
            //         notEmpty: {
            //             message: '启用日期必须填写'
            //         }
            //     }
            // },
            // purchasedTime: {
            //     validators: {
            //         notEmpty: {
            //             message: '购买日期必须填写'
            //         }
            //     }
            // },
            // checkPeriod: {
            //     validators: {
            //         notEmpty: {
            //             message: '鉴定周期必须填写'
            //         }
            //     }
            // },
            // place: {
            //     validators: {
            //         notEmpty: {
            //             message: '安装位置必须填写'
            //         }
            //     }
            // },
            // owner: {
            //     validators: {
            //         notEmpty: {
            //             message: '责任人必须填写'
            //         }
            //     }
            // },
            // checkPermission: {
            //     validators: {
            //         notEmpty: {
            //             message: '鉴定权限必须填写'
            //         }
            //     }
            // }
        }
    });

})

