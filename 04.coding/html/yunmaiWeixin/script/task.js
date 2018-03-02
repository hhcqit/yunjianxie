Vue.component('v-select', VueSelect.VueSelect);
        var vm = new Vue({
            el: "#task",
            data: {
                loginData: {
                    token: "",
                    user: {
                        dept: "",
                        realName: "",
                        userName: ""
                    },
                    org: {

                    }
                },
                deviceNameList: [], //设备列表
                selected: null, //选中的设备情况
                description: ""
            },
            computed: {

            },
            methods: {
                task: function () {
                    var _self = this;
                    if (_self.selected == null) {
                        mui.alert("设备不能为空");
                    } else if (_self.description == "") {
                        mui.alert("任务描述不能为空");
                    } else {
                        $.ajax({
                            type: 'post',
                            dataType: 'json',
                            contentType: "application/json;charset=utf-8",
                            xhrFields: {
                                withCredentials: true
                            },
                            url: jQuery.url + '/task/save',
                            data: JSON.stringify({
                                "attachmentIds": "",
                                "description": _self.description,
                                "equipId": _self.selected.id
                            }),
                            headers: {
                                'token': _self.loginData.token,
                            },
                            complete: function (jqxhr, txt_status) {
                                if (txt_status == "error") {
                                    console.log(JSON.stringify(jqxhr));
                                    mui.alert("服务器请求失败");
                                }
                            },
                            success: function (data) {
                                console.log(data)
                                if (data.code == 0) {
                                    mui.alert(data.msg, function () {
                                        location.href = "taskList.html";
                                    });
                                } else {
                                    mui.alert(data.msg);
                                }

                            },
                            err: function (err) {
                                alert('err')
                                mui.alert(err);
                            }
                        })
                    }
                }
            },
            beforeCreate: function () {

            },
            created: function () {
                //加载登录信息
                var _self = this;
                var data = JSON.parse(localStorage.getItem('loginData'));
                _self.loginData = data;
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
                        bind: 1 //只查询已绑定服务商的设备的设备
                    }),
                    headers: {
                        'token': _self.loginData.token
                    },
                    success: function (data) {
                        console.log(JSON.stringify(data));
                        _self.deviceNameList = data.data
                        var Data = data.data;
                        if (data.code == 0) {
                            _self.deviceNameList = $.map(data.data, function (obj) {
                                return {
                                    id: obj.id,
                                    label: obj.name,
                                    code: obj.code,
                                    place: obj.place
                                };
                            });
                        }
                    },
                    err: function (err) {
                        swal("", err, "error");
                    }
                });
            },
            mounted: function () {
                var _self = this;

            }

        })