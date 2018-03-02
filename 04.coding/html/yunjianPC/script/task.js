Vue.filter('moment', function (value, formatString) {
    formatString = formatString || 'YYYY-MM-DD HH:mm:ss';
    // return moment(value).format(formatString); // value可以是普通日期 20170723
    return moment.unix(value).format(formatString); // 这是时间戳转时间
});
Vue.component('my-content', {
template:"#task-template",
    data: function () {
        return {
            org: JSON.parse(localStorage.getItem('org')),
            user: JSON.parse(localStorage.getItem('user')),
            date: moment().format('YYYY-MM-DD HH:mm:ss'),
            uploader: undefined,
            datatable_obj: null,
            loginStyle: loginStyle,
            statusList: [],//状态列表
            deviceNameList: [],//设备列表
            taskList: [],//报修列表
            chkList: {
                examineCalibrate: "",
                examineDescription: "",
                examineQc: "",
                examineSample: "",
                malfunctionDuration: 5,
                action: "",
                id: ""//任务主键
            }
        }
    },
    computed: {
        isLab: function () {//判断是实验室还是服务商人员
            return loginStyle == 1;
        },
        title: function () {
            return this.isLab ? '报修' : '巡检'
        }
    },
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
                        data: 'status', render: function (data, type, row) {
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
        add: function () {//我要报修
            var _self = this;
            document.getElementById("addForm").reset();
            document.getElementById('theList').innerHTML = "";
            $("#addForm .select2").val("").trigger("change");
            $("#addForm").data("bootstrapValidator").resetForm();//重置表单验证
            $("#modalAdd").modal({ backdrop: 'static', keyboard: false });
        },
        track: function () {//跟踪
            var _self = this;
            swal("功能维护中");
        },
        check: function () {//验收
            var _self = this;
            if (_self.datatable_obj.rows('.selected').data().length > 0) {
                //重置表单数据
                _self.chkList = {
                    examineCalibrate: "",
                    examineDescription: "",
                    examineQc: "",
                    examineSample: "",
                    malfunctionDuration: 5,
                    action: "",
                    id: _self.datatable_obj.rows('.selected').data().id//任务主键
                }
                $("#chkForm").data("bootstrapValidator").resetForm();//重置表单验证
                $("#modalChk").modal({ backdrop: 'static', keyboard: false });
            } else {
                _self.FnAlert();
            }
        },
        grade: function () {//评分
            var _self = this;
            if (_self.datatable_obj.rows('.selected').data().length > 0) {
                document.getElementById('gradeForm').reset();
                $("#modalGrade").modal({ backdrop: 'static', keyboard: false });
            } else {
                _self.FnAlert();
            }
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
                $ele.parent().parent().remove();
                _self.uploader.removeFile(_self.uploader.getFile(id), true);
                // }
            });
        },//
        FnEditSave: function () {//新增任务保存按钮
            var _self = this;
            var formData = new FormData($("#addForm")[0]);
            console.log(formData)
            $("#addForm").data("bootstrapValidator").resetForm();//重置表单验证
            var bootstrapValidator = $("#addForm").data('bootstrapValidator');
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
                        url: jQuery.url + '/task/save',
                        data: JSON.stringify({
                            "attachmentIds": arr.join(','),
                            "description": $("[name='description']").val(),
                            "equipId": $("[name='equipId']").val()
                        }),
                        headers: {
                            'token': localStorage.getItem("token"),
                        },
                        complete: function (jqxhr, txt_status) {
                            if (txt_status == "error") {
                                console.log(JSON.stringify(jqxhr));
                                swal("", "服务器请求失败", "error")
                            }
                        },
                        success: function (data) {
                            console.log(data)
                            if (data.code == 0) {
                                //刷新列表内容
                                var currentPage = _self.datatable_obj.page();
                                console.log(currentPage)
                                $('#merchant-list').DataTable().destroy();
                                _self.taskGetList();
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
                                swal("报修失败", data.msg, "error");
                            }

                        },
                        err: function (err) {
                            alert('err')
                            swal("", err, "error");
                        }
                    })
                }
            } else {
                console.log('表单验证失败');
            }
        },
        taskExamine: function (val) {//验收保存按钮modalChk
            var _self = this;
            _self.chkList.action = val;
            $("#chkForm").data("bootstrapValidator").resetForm();//重置表单验证
            var bootstrapValidator = $("#chkForm").data('bootstrapValidator');
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
                            //验收任务
                            $.ajax({
                                type: 'post',
                                dataType: 'json',
                                contentType: "application/json; charset=utf-8;",
                                xhrFields: {
                                    //设置跨域请求
                                    withCredentials: true
                                },
                                url: jQuery.url + '/task/examine',
                                data: JSON.stringify(_self.chkList),
                                headers: {
                                    'token': localStorage.getItem("token")
                                },
                                success: function (data) {
                                    console.log(JSON.stringify(data));
                                    if (data.code == 0) {
                                        //刷新列表内容
                                        var currentPage = _self.datatable_obj.page();
                                        console.log(currentPage)
                                        $('#merchant-list').DataTable().destroy();
                                        _self.taskGetList();
                                        _self.initCategoryDataTables();
                                        //关闭弹窗
                                        $("#modalChk").modal('hide');
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
        FnBindSave: function () {//评分保存按钮
            var _self = this;
            swal({
                title: "确定要保存吗?",
                text: "一旦保存，数据将被修改!",
                icon: "warning",
                buttons: true,
                dangerMode: true,
            })
                .then(function (willDelete) {
                    if (willDelete) {
                        $.ajax({
                            type: 'post',
                            dataType: 'json',
                            contentType: "application/json;charset=utf-8",
                            xhrFields: {
                                withCredentials: true
                            },
                            url: jQuery.url + '/task/comment',
                            data: JSON.stringify({
                                "description": "",
                                "id": _self.datatable_obj.rows('.selected').data().id,
                                "response": $('#rating-service').val() != "" ? $('#rating-service').val() : 0,
                                "service": $('#rating-skills').val() != "" ? $('#rating-skills').val() : 0,
                                "technology": $('#rating-response').val() != "" ? $('#rating-response').val() : 0
                            }),
                            headers: {
                                'token': localStorage.getItem("token"),
                            },
                            complete: function (jqxhr, txt_status) {
                                if (txt_status == "error" || txt_status == "parsererror") {
                                    console.log(JSON.stringify(jqxhr));
                                    swal("", "服务器请求失败", "error")
                                }
                            },
                            success: function (data) {
                                if (data.code == 0) {
                                    //TODO 添加&修改操作
                                    $("#modalGrade").modal('hide');
                                    swal("保存成功", {
                                        icon: "success",
                                    });
                                } else {
                                    swal("", data.msg, "error")
                                }
                            },
                            err: function (err) {
                                alert('err')
                                swal("", err, "error");
                            }
                        })

                    } else {
                        swal("没有操作!");
                    }
                });
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
        });
        //状态列表
        if (_self.isLab) {
            _self.statusList = [{
                "id": "未完成",
                "text": "未完成"
            },
            {
                "id": "完成",
                "text": "完成"
                // "selected": true
            },
            {
                "id": "已撤销",
                "text": "已撤销"

            }];
        } else {
            _self.statusList = [{
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

            }];
        }

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
        //评分组件初始化
        $('#rating-service').rating({
            min: 0,
            max: 5,
            step: 1,
            size: 'xxs',
            showClear: true
        });
        $('#rating-skills').rating({
            min: 0,
            max: 5,
            step: 1,
            size: 'xxs',
            showClear: true
        });
        $('#rating-response').rating({
            min: 0,
            max: 5,
            step: 1,
            size: 'xxs',
            showClear: true
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
    el: "#task",
    data: {
        org: JSON.parse(localStorage.getItem('org')),
        user: JSON.parse(localStorage.getItem('user'))
    }
});

