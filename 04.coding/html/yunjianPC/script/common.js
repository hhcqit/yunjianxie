// jQuery.url = "http://wx.ailabcare.com/kuaixiu";
jQuery.url = "http://wx.ailabcare.com/kuaixiu/";
//登录成功 判定用户类型为  1实验室 or 2服务商
// console.log(JSON.parse(localStorage.getItem('org')));
if (localStorage.getItem('token')) {
    var loginStyle = JSON.parse(localStorage.getItem('org')).type;
    var sidebarmenu = undefined;
    //加载左边菜单数据
    if (loginStyle == 2) {
        //服务商
        sidebarmenu = [
            { name: "首页", icon: "fa fa-desktop", html: "index" },
            { name: "我的设备", icon: "fa fa-tv", html: "device" },
            { name: "我要巡检", icon: "fa  fa-gavel", html: "task" },
            { name: "我的维修", icon: "fa  fa-gavel", html: "myTask" },
            { name: "保养计划", icon: "fa  fa-bell", html: "maintenancePlan" },
            { name: "保养任务", icon: "fa fa-tag", html: "maintenanceWork" },
            { name: "校准计划", icon: "fa  fa-arrows", html: "checkPlan" },
            { name: "鉴定&校准任务", icon: "fa  fa-gavel", html: "identification" },
            { name: "我的成员", icon: "fa  fa-user", html: "remembers" },
            { name: "我的客户", icon: "fa  fa-users", html: "seviceProviders" },
            { name: "系统设置", icon: "fa  fa-gear", html: "settings" }
        ];
    } else if (loginStyle == 1) {
        //实验室
        sidebarmenu = [
            { name: "首页", icon: "fa fa-desktop", html: "index" },
            { name: "我的设备", icon: "fa fa-tv", html: "device" },
            { name: "我要报修", icon: "fa fa-wrench", html: "task" },
            { name: "保养计划", icon: "fa  fa-bell", html: "maintenancePlan" },
            { name: "保养任务", icon: "fa fa-tag", html: "maintenanceWork" },
            { name: "校准计划", icon: "fa  fa-arrows", html: "checkPlan" },
            { name: "检定&校准任务", icon: "fa  fa-gavel", html: "identification" },
            { name: "我的成员", icon: "fa  fa-user", html: "remembers" },
            { name: "我的服务商", icon: "fa  fa-users", html: "seviceProviders" },
            { name: "系统设置", icon: "fa  fa-gear", html: "settings" }
        ];
    } else {
        alert("用户未登录或登录账号过期");
        location.href = '../login.html';
    }

    //加载左边菜单
    if (sidebarmenu != undefined) {
        sidebarmenu.forEach(function (k, i, array) {
            $(".sidebar-menu").append('<li><a href="' + k.html + '.html"><i class="' + k.icon + '"></i> <span>' + k.name + '</span></a></li>');
        });
    }

} else {
    swal("", "用户未登录或登录账号过期", "error");
    location.href = '../login.html';
}

//number组件增减按钮事件
(function ($) {
    $('body').on('click', '.spinner .btn.minus', function () {
        console.log($(this).parent().parent().children('input'))
        $(this).parent().parent().children('input').val(parseInt($(this).parent().parent().children('input').val().trim(), 10) - 1);
        if (parseInt($(this).parent().parent().children('input').val().trim(), 10) == 0) {
            $(this).prop('disabled', true);
        }
    });
    $('body').on('click', '.spinner .btn.plus', function () {
        $(this).parent().parent().children('input').val(parseInt($(this).parent().parent().children('input').val().trim(), 10) + 1);
        if (parseInt($(this).parent().parent().children('input').val().trim(), 10) > 0) {
            $(this).parent().parent().find('.minus').prop('disabled', false);
        }
    });
})(jQuery);

function crtTimeFtt(val, row) {
    if (val != null) {
        var date = new Date(val);
        return date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate();
    }
}

//获取时间yyyyddmm
function getNowFormatDate() {
    var date = new Date();
    var seperator0 = "";
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator0 + month + seperator0 + strDate;
    // + " " + date.getHours() + seperator2 + date.getMinutes()
    // + seperator2 + date.getSeconds();
    return currentdate;
}


//头部 
const Header = {
    props: ['myName'],
    template: `<header class="main-header">
            <a href="index.html" class="logo">
                <span class="logo-mini">
                    <b>KMY</b>
                </span>
                <span class="logo-lg">
                    <b>科脉云</b>设备管理平台</span>
            </a>
            <nav class="navbar navbar-static-top">
                <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                    <span class="sr-only">折叠</span>
                </a>
                <div class="navbar-custom-menu">
                    <ul class="nav navbar-nav">
                        <li class="dropdown user user-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <img src="../AdminLTE-2.4.2/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
                                <span class="hidden-xs">{{myName }}</span>
                            </a>
                            <ul class="dropdown-menu">
                                <li class="user-header">
                                    <img src="../AdminLTE-2.4.2/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                                    <p>
                                        {{myName }}
                                    </p>
                                </li>

                                <li class="user-footer">

                                    <div class="pull-right">
                                        <a href="../login.html" class="btn btn-default btn-flat">退出登录</a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>`
}
//尾部
const Footer = {
    props: [''],
    template: ` <!--尾部-->
<footer class="main-footer">
    <div class="pull-right hidden-xs">
         <b>Version</b> 1.0.0
    </div>
    <strong>Copyright &copy; 2018-2020
        <a href="#">科脉云设备管理平台</a>.</strong> All rights reserved.
</footer>
<!--/尾部-->` }
//左侧菜单
const Aside = {
    props: ['myType', 'myName'],
    data: function () {
        if (this.myType == 2) {
            return {
                'sidebarmenu': [
                    { name: "首页", icon: "fa fa-desktop", html: "index.html" },
                    { name: "我的设备", icon: "fa fa-tv", html: "device.html" },
                    { name: "我要巡检", icon: "fa  fa-gavel", html: "task.html" },
                    { name: "我的维修", icon: "fa  fa-gavel", html: "myTask.html" },
                    { name: "保养计划", icon: "fa  fa-bell", html: "maintenancePlan.html" },
                    { name: "保养任务", icon: "fa fa-tag", html: "maintenanceWork.html" },
                    { name: "校准计划", icon: "fa  fa-arrows", html: "checkPlan.html" },
                    { name: "鉴定&校准任务", icon: "fa  fa-gavel", html: "identification.html" },
                    { name: "我的成员", icon: "fa  fa-user", html: "remembers.html" },
                    { name: "我的客户", icon: "fa  fa-users", html: "seviceProviders.html" },
                    { name: "系统设置", icon: "fa  fa-gear", html: "settings.html" }
                ]
            }
        } else if (this.myType == 1) {
            return {
                'sidebarmenu': [//实验室
                    { name: "首页", icon: "fa fa-desktop", html: "index.html" },
                    { name: "我的设备", icon: "fa fa-tv", html: "device.html" },
                    { name: "我要报修", icon: "fa fa-wrench", html: "task.html" },
                    { name: "保养计划", icon: "fa  fa-bell", html: "maintenancePlan.html" },
                    { name: "保养任务", icon: "fa fa-tag", html: "maintenanceWork.html" },
                    { name: "校准计划", icon: "fa  fa-arrows", html: "checkPlan.html" },
                    { name: "检定&校准任务", icon: "fa  fa-gavel", html: "identification.html" },
                    { name: "我的成员", icon: "fa  fa-user", html: "remembers.html" },
                    { name: "我的服务商", icon: "fa  fa-users", html: "seviceProviders.html" },
                    { name: "系统设置", icon: "fa  fa-gear", html: "settings.html" }
                ]
            }
        } else {
            return {}
        }
    },
    template: `<aside class="main-sidebar">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar user panel -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="../AdminLTE-2.4.2/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                        </div>
                        <div class="pull-left info">
                            <p href="#">
                                <i class="fa fa-circle text-success"></i> 登录用户</p>
                            <p>{{myName}}</p>
                        </div>
                    </div>
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu" data-widget="tree" id="sidebar-menu">
                        <li v-for="k in sidebarmenu">
                            <a v-bind:href="k.html">
                            <i v-bind:class="k.icon"></i> 
                            <span>{{k.name}}</span>
                            </a>
                        </li>
                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>`
}


// 注册
Vue.component('my-header', Header)
Vue.component('my-aside', Aside)
Vue.component('my-footer', Footer)

  
Vue.filter('moment', function (value, formatString) {
    formatString = formatString || 'YYYY-MM-DD HH:mm:ss';
    // return moment(value).format(formatString); // value可以是普通日期 20170723
    return moment.unix(value).format(formatString); // 这是时间戳转时间
});