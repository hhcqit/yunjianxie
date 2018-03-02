Vue.component('my-content', {
    template: "#main-template",
    data: function () {
        return {
            loginStyle: loginStyle,
            org: JSON.parse(localStorage.getItem('org')),
            user: JSON.parse(localStorage.getItem('user'))
        }
    }
})
var vm = new Vue(
    {

        el: "#serviceProviders",
        data: {
            loginStyle: loginStyle,
            org: JSON.parse(localStorage.getItem('org')),
            user: JSON.parse(localStorage.getItem('user'))
        },
        created: function () {

        }
    })
let datatable_obj = null;//主表
$(document).ready(function () {
    if (loginStyle == 2) {//服务商
        $("section.content-header").html('<h1>我的客户</h1>')
        $("#addBtn").html("邀请更多客户");
        $("#delBtn").html("移除客户");
    } else {//实验室
        $("section.content-header").html('<h1>我的服务商</h1>')
        $("#addBtn").html("邀请更多服务商");
        $("#delBtn").html("移除服务商");
    }
    //初始化表格
    providerOrCustomer.initCategoryDataTables();
    makeCode();
});
var providerOrCustomer = {
    initCategoryDataTables: function () {
        // /org/getBindList 获取绑定组织列表
        $.ajax({
            type: 'post',
            dataType: 'json',
            contentType: "application/json; charset=utf-8;",
            xhrFields: {
                //设置跨域请求
                withCredentials: true
            },
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
                    datatable_obj = $('#merchant-list').DataTable({
                        data: data.data,
                        columns: [
                            { data: 'name' },
                            { data: 'telephone' },
                            { data: 'email' },
                            { data: 'postcode' },
                            { data: 'address' },
                            { data: 'area' }
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
                } else if (data.code == 1) {
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
    add: function () {
        $("#modalAdd").modal({ backdrop: 'static', keyboard: false });
    },
    del: function () {//移除绑定组织
        if (datatable_obj.rows('.selected').data().length > 0) {
            swal({
                title: "确定要删除吗?",
                text: "一旦删除，将不能找回!",
                icon: "warning",
                buttons: true,
                dangerMode: true,
            })
                .then(function (willDelete) {
                    if (willDelete) {
                        console.log(datatable_obj.row('.selected').data().id);
                        $.ajax({
                            type: 'post',
                            dataType: 'json',
                            contentType: "application/json; charset=utf-8;",
                            xhrFields: {
                                //设置跨域请求
                                withCredentials: true
                            },
                            url: jQuery.url + '/org/unbind',
                            data: JSON.stringify({
                                id: datatable_obj.row('.selected').data().id
                            }),
                            headers: {
                                'token': localStorage.getItem('token'),
                            },
                            success: function (data) {
                                // console.log(data);
                                // 删除功能数据库没有实现
                                if (data.code == 0) {
                                    datatable_obj.row('.selected').remove().draw();
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
            FnAlert();
        }

    }
};
function FnAlert() {
    swal("操作有误!", "请选择要编辑的数据行!", "error");
}
//绑定datatable#merchant-list表格点击选中事件
$('#merchant-list').on('click', 'tbody tr', function () {
    if ($(this).hasClass('selected')) {
        $(this).removeClass('selected');
        CategoryCodeValue = "";
    }
    else {
        datatable_obj.$('tr.selected').removeClass('selected');
        $(this).addClass('selected');
        CategoryCodeValue = datatable_obj.row(this).data()["code"];
    }
});


function makeCode() {//生成二维码图片
    var id = JSON.parse(localStorage.getItem('org')).type.id//登录组织主键
    var name = JSON.parse(localStorage.getItem('org')).type.name//登录组织名称
    //根据id生成二维码
    var qrcode = new QRCode(document.getElementById("qrcode"), {
        width: 150,
        height: 150
    });
    //todo
    qrcode.makeCode('http://wx.ailabcare.com/kuaixiu/common/attachment/' + '25');
}