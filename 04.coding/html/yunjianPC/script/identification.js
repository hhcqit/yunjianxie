Vue.component('my-content', {
    template: "#main-template",
    data: function () {
        return {
            org: JSON.parse(localStorage.getItem('org')),
            user: JSON.parse(localStorage.getItem('user')),
            uploader: undefined,
            datatable_obj: null,
            loginStyle: loginStyle,
            deviceNameList: [],//设备列表
            workList: [],//任务列表
            orgList: []//所有组织列表，包括实验室和服务商
        }
    },
    computed: {
        isLab: function () {//判断是实验室还是服务商人员
            return loginStyle == 1;
        }
    },
    watch: {},
    methods: {
        orgGetList: function () {
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
                url: jQuery.url + '/org/getList',
                data: JSON.stringify({
                    "pageNumber": 0,
                    "pageSize": 1000,
                    "type": 0 //0、全部 1、实验室 2、服务商
                }),
                headers: {
                    'token': localStorage.getItem('token'),
                },
                success: function (data) {
                    // console.log(JSON.stringify(data));
                    if (data.code == 0) {
                        _self.orgList = data.data;
                    } else {
                        swal("", data.msg, "error")
                    }
                },
                err: function (err) {
                    swal("", err, "error")
                }
            });
        },
        workGetList: function () {
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
                url: jQuery.url + '/work/getList',
                data: JSON.stringify({
                    "pageNumber": 0,
                    "pageSize": 1000,
                    "type": 2//检定任务
                }),
                headers: {
                    'token': localStorage.getItem('token'),
                },
                success: function (data) {
                    // console.log(JSON.stringify(data));
                    if (data.code == 0) {
                        _self.workList = data.data;
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
        FnEditSave: function () {//新增任务保存按钮
            var _self = this;
            $("#addForm").data("bootstrapValidator").resetForm();//重置表单验证
            var bootstrapValidator = $("#addForm").data('bootstrapValidator');
            bootstrapValidator.validate();
            if (bootstrapValidator.isValid()) {
                swal({
                    title: "确定要保存吗?",
                    text: "一旦保存，将新增检定任务!",
                    icon: "warning",
                    buttons: true,
                    dangerMode: true,
                })
                    .then(function (willDelete) {
                        if (willDelete) {
                            var postData = {
                                "equipId": parseInt($('#addForm [name="equipId"]').val()),//设备主键
                                "content": $('#addForm [name="content"]').val(),//检定内容
                                "name": $('#addForm [name="equipId"] option:selected').html() + getNowFormatDate() + "检定",//任务名称：设备名称yyyymmdd检定,
                                "type": 2//1保养计划 2检定计划
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
                                url: jQuery.url + '/work/save',
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
                                        _self.workGetList();
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
        FnExecuteSave: function () {
            var _self = this;
            var formData = new FormData($("#executeForm")[0]);
            console.log(formData)
            $("#executeForm").data("bootstrapValidator").resetForm();//重置表单验证
            var bootstrapValidator = $("#executeForm").data('bootstrapValidator');
            bootstrapValidator.validate();
            if (bootstrapValidator.isValid()) {
                if ($('.state.waiting').length != 0 || $('.state').length == 0) {
                    swal("", "请检查是否上传附件或有待上传附件", "error");
                    return false
                } else {
                    var ids = $('#theList [type="hidden"]');
                    var arr = [];
                    for (var i = 0; i < ids.length; i++) {
                        arr.push(ids[i].value)
                    }
                    console.log(arr.join(','));
                    // 得到id之后进行执行作业
                    $.ajax({
                        type: 'post',
                        dataType: 'json',
                        contentType: "application/json;charset=utf-8",
                        xhrFields: {
                            withCredentials: true
                        },
                        url: jQuery.url + '/work/execute',
                        data: JSON.stringify({
                            "attachmentIds": arr.join(','),
                            "certificateNo": $("[name='certificateNo']").val(),
                            "id": _self.datatable_obj.row('.selected').data().id,
                            "result": $("[name='result']").val()
                        }),
                        headers: {
                            'token': localStorage.getItem("token"),
                        },
                        success: function (data) {
                            console.log(data)
                            if (data.code == 0) {
                                //刷新列表内容
                                var currentPage = _self.datatable_obj.page();
                                console.log(currentPage)
                                $('#merchant-list').DataTable().destroy();
                                _self.workGetList();
                                _self.initCategoryDataTables();
                                //关闭弹窗
                                $("#modalExecute").modal('hide');
                                //显示成功信息
                                swal("保存成功", {
                                    icon: "success",
                                });
                                setTimeout(function () {
                                    _self.datatable_obj.page(currentPage).draw(false);
                                }, 200);
                            }else{
                                swal("", data.msg, "error");
                            }

                        },
                        err: function (err) {
                            swal("", err, "error");
                        }
                    })
                }
            } else {
                console.log('表单验证失败');
            }

        },
        FnUploadAttachment: function () {
            var _self = this;
            var $ = jQuery,
                $list = $('#theList'),
                ratio = window.devicePixelRatio || 1,
                thumbnailWidth = 50 * ratio,
                thumbnailHeight = 50 * ratio
            // 初始化Web Uploader
            _self.uploader = WebUploader.create({
                // 选完文件后，是否自动上传。
                auto: false,
                // swf文件路径
                swf: '../lib/webuploader/Uploader.swf',
                // 文件接收服务端。
                server: jQuery.url + '/common/uploadAttachment',
                headers: {
                    token: localStorage.getItem("token")
                },
                // 选择文件的按钮。可选。
                // 内部根据当前运行是创建，可能是input元素，也可能是flash.
                pick: '#filePicker2',
                // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
                resize: false,
                formData: {
                    file: $('#attachType').val()
                },
                fileSizeLimit: 2000 * 1024,//限制大小2000kb，所有被选文件，超出选择不上
                // 只允许选择图片文件。
                accept: {
                    title: 'Images',
                    extensions: 'jpg,png',
                    mimeTypes: 'image/jpg,image/png'   //修改这行
                }
            });
            _self.uploader.on("error", function (type) {
                if (type == "F_DUPLICATE") {
                    alert("请不要重复选择文件");
                } else if (type == "Q_EXCEED_SIZE_LIMIT") {
                    alert("所选附件大小不可超过2000KB");
                }
            });
            _self.uploader.on('beforeFileQueued', function (file) {
                if ("" == file.ext || null == file.ext) {
                    return false
                }
            });
            // 当有文件添加进来的时候
            _self.uploader.on('fileQueued', function (file) {
                console.log(file)
                var $li = $(
                    // '<div id="' + file.id + '" class="item waiting" style="height: 26px;border-radius: 5px;padding-left:10px;">' +
                    // '<img>'+
                    // '<b class="info">' + file.name + '</b>' +
                    // '<span class="state">等待上传...</span>' +
                    // '<a class="btn"  href="javascript:void(0)" name="BtnCancel" >删除</a>' +
                    // '</div>'+
                    // '<div class="row" style="border: 1px solid green;" id="' + file.id + '" >\n' +
                    // '                                                        <div class="col-xs-12" style="height: 40px;display: flex;align-items: center;">\n' +
                    // '                                                            <img style="width:40px;height: 40px;">\n' +
                    // '                                                            <b class="info" style="flex-grow:2">' + file.name + '</b>\n' +
                    // '                                                            <span class="state" style="margin-right: 15px;">等待上传</span>\n' +
                    // '                                                            <button type="button" class="btn btn-primary  icon-plus">删除</button>\n' +
                    // '                                                        </div>\n' +
                    // '                                                        <div class="col-xs-12">\n' +
                    // '                                                            <div class="progress active">\n' +
                    // '                                                                <div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">\n' +
                    // '                                                                    <span>20% Complete</span>\n' +
                    // '                                                                </div>\n' +
                    // '                                                            </div>\n' +
                    // '                                                        </div>\n' +
                    // '                                                    </div>'
                    '<div class="row item" id="' + file.id + '" >' +
                    '<div class="col-xs-12" style="height: 50px;display: flex;align-items: center;">' +
                    '<img style="width:50px;height: 50px;">' +
                    '<b class="info" style="flex-grow:2">' + file.name + '</b>' +
                    '<span class="state waiting" style="margin-right: 15px;">等待上传</span>' +
                    '<button type="button" class="btn btn-primary  icon-plus del">删除</button>' +
                    '<input type="hidden" name="' + file.id + '">' +
                    '</div>' +
                    '</div>'
                );
                $img = $li.find('img');
                // $list为容器jQuery实例
                $list.append($li);
                // 创建缩略图
                // 如果为非图片文件，可以不用调用此方法。
                // thumbnailWidth x thumbnailHeight 为 100 x 100
                _self.uploader.makeThumb(file, function (error, src) {
                    if (error) {
                        $img.replaceWith('<span>不能预览</span>');
                        return;
                    }

                    $img.attr('src', src);
                }, thumbnailWidth, thumbnailHeight);
            });
            // 文件上传过程中创建进度条实时显示。
            _self.uploader.on('uploadProgress', function (file, percentage) {
                console.log(percentage)
                var $li = $('#' + file.id),
                    $percent = $li.find('.progress span');

                // 避免重复创建
                if (!$percent.length) {
                    $percent = $('<p class="progress"><span></span></p>')
                        .appendTo($li)
                        .find('span');
                }

                $percent.css('width', percentage * 100 + '%');
            });
            _self.uploader.on('uploadSuccess', function (file, response) {
                console.log(response);
                $('#' + file.id).find('span.state').text('已上传');
                $('#' + file.id).find('span.state').removeClass("waiting");
                // $('#' + file.id).find('.del').prop('id', response.data[0].attachId);
                $('#' + file.id).addClass('upload-state-done');
                $('[name="' + file.id + '"]').val(response.data);
            });
            // 文件上传到服务器，处理后返回消息
            _self.uploader.on('uploadAccept', function (file, response) {


            });
            _self.uploader.on('uploadError', function (file) {
                var $li = $('#' + file.id), $error = $li.find('span.state');
                $error.text('上传失败');
            });
            // 完成上传完了，成功或者失败，先删除进度条。
            _self.uploader.on('uploadComplete', function (file) {
                $('#' + file.id).find('.progress').remove();
            });
            //点击上传文件
            $('#ctlBtn').on('click', function (e) {
                var e = e || window.event;
                e.preventDefault(); // 兼容标准浏览器
                _self.uploader.upload();
            });
            //删除
            $list.on("click", ".del", function () {
                var $ele = $(this);
                var id = $ele.parent().parent().attr("id");
                var $li = $('#' + id);
                // // console.log(uploader.getFiles());
                // if (this.id != null && this.id != '') {
                //     alert(1)
                //     $.ajax({
                //         type: 'post',
                //         data: { attachId: this.id },
                //         url: "http://webuploader.duapp.com/server/fileupload.php",
                //         success: function (data) {
                //             alert('succ')
                //             $ele.parent().remove();
                //             _self.uploader.removeFile(_self.uploader.getFile(id), true);
                //         }
                //     })
                // } else {
                // alert(2)
                $ele.parent().parent().remove();
                _self.uploader.removeFile(_self.uploader.getFile(id), true);
                // }
            });
        },
        initCategoryDataTables: function () {
            var _self = this;
            // console.log(_self.workList)
            //绘制表格
            _self.datatable_obj = $('#merchant-list').DataTable({
                data: _self.workList,
                columns: [
                    { data: 'name' },//计划名称
                    { data: 'equipName' },//设备名称
                    { data: 'period' },//周期
                    { data: 'content' },//检定项目
                    {
                        data: 'executePermission',
                        "render": function (data, type, row, meta) {
                            if (data == 0) {
                                return "不限"
                            } else if (data == 1) {
                                return "内部执行"
                            } else if (data == 2) {
                                return '外部执行'
                            } else {
                                return ""
                            }
                        }
                    },//执行权限 0、不限 1、内部 2、外部 ,
                    {
                        data: 'status',
                        "render": function (data, type, row, meta) {
                            if (data == 0) {
                                return "未开始"
                            } else if (data == 1) {
                                return "执行中"
                            } else if (data == 2) {
                                return '待确认'
                            } else if (data == 3) {
                                return "已完成"
                            } else {
                                return ""
                            }
                        }
                    },//状态0、未开始 1、执行中 2、待确认 3、已完成 ,
                    { data: 'executeUser' },//执行人
                    {
                        data: 'executeTime',
                        render: function (data, type, row) {
                            if (data != null && data != '') {
                                return moment(data).format('YYYY-MM-DD');
                            } else {
                                return null
                            }
                        }
                    },//执行时间
                    {
                        data: 'executeOrgId',
                        render: function (data, type, row) {
                            for (var i = 0; i < _self.orgList.length; i++) {
                                if (data == _self.orgList[i].id) {
                                    return _self.orgList[i].name
                                }
                            }
                            return ""
                        }
                    },//执行单位
                    { data: 'result' },//执行结果
                    { data: 'certificateNo' }//证书编号
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
        add: function () {//新增检定
            document.getElementById("addForm").reset();
            $("#addForm .select2").val("").trigger("change");
            $("#addForm").data("bootstrapValidator").resetForm();//重置表单验证
            $("#modalAdd").modal({ backdrop: 'static', keyboard: false });
        },
        upd: function () {//执行检定
            var _self = this;
            //数据回填
            if (_self.datatable_obj.rows('.selected').data().length > 0) {
                var callbackData = _self.datatable_obj.row('.selected').data();
                console.log(callbackData);
                if(callbackData.status==3){
                    swal('','已执行完成，不能重复执行','error');
                }else{
                    document.getElementById("executeForm").reset();
                    document.getElementById('theList').innerHTML = "";
                    $("#executeForm").data("bootstrapValidator").resetForm();//重置表单验证
                    $("#executeForm [name='result']").val(callbackData.result);
                    $("#executeForm [name='certificateNo']").val(callbackData.certificateNo);
                    $("#modalExecute").modal({ backdrop: 'static', keyboard: false });
                }
                
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
        _self.workGetList();
        //获取组织列表
        _self.orgGetList();
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
            _self.Fnsearch(this.value, 1);
        });

        //全局搜索框
        $('input.global_filter').on('keyup click', function () {
            _self.filterGlobal();
        });
        //初始化表格
        _self.initCategoryDataTables();
        // 添加各个表单的提交验证
        $("#addForm").bootstrapValidator({
            submitHandler: function (valiadtor, loginForm, submitButton) {
                $('#addForm').bootstrapValidator('disableSubmitButtons', false);
            },
            fields: {
                equipId: {
                    validators: {
                        notEmpty: {
                            message: '请选择设备名称'
                        }
                    }
                },
                content: {
                    validators: {
                        notEmpty: {
                            message: '内容必须填写'
                        }
                    }
                }
            }
        })
        $("#executeForm").bootstrapValidator({
            submitHandler: function (valiadtor, loginForm, submitButton) {
                $('#executeForm').bootstrapValidator('disableSubmitButtons', false);
            },
            fields: {
                result: {
                    validators: {
                        notEmpty: {
                            message: '结论不能为空'
                        }
                    }
                },
                certificateNo: {
                    validators: {
                        notEmpty: {
                            message: '编号不能为空'
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
        //新建适时保养的上传组件只能初始化一次
        $("#modalExecute").on("shown.bs.modal", function () {
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
    el: "#maintenanceWork",
    data: {
        org: JSON.parse(localStorage.getItem('org')),
        user: JSON.parse(localStorage.getItem('user'))
    }
});



