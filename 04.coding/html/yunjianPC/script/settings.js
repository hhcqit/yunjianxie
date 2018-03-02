Vue.component('my-content', {
    template: "#main-template",
    data: function () {
        return {
            org: "",
            user: "",
            token: "",
            list: {},
            infoList: {},
            secretList: {
                secret: "",
                secretAgain: ""
            },
            passwordModel: "",
            passwordcheckModel: ""
        }
    },
    methods: {
        getOrg: function () {
            var _self = this;
            //获取注册账号信息
            $.ajax({
                type: 'post',
                dataType: 'json',
                contentType: "application/json; charset=utf-8;",
                xhrFields: {
                    //设置跨域请求
                    withCredentials: true
                },
                async: false,
                url: jQuery.url + '/org/getOrg',
                data: JSON.stringify({
                    id: _self.org.id
                }),
                headers: {
                    'token': _self.token,
                },
                success: function (data) {
                    console.log(data.data);
                    if (data.code == 0) {
                        _self.list = data.data;
                    } else {
                       swal("",data.msg,"error")
                    }
                },
                err: function (err) {
                    swal("",err,"error")
                }
            });
        },
        infoOpen: function () {
            var _self = this;
            var oldData = _self.list
            //将原始值赋值给infoList作为弹出窗口的数据来源
            _self.infoList = JSON.parse(JSON.stringify(oldData));
            // _self.infoList.area = "浙江省-杭州市-萧山区";
            if (_self.infoList.area) {//回填省-市-区
                var province = _self.infoList.area.split('-')[0];
                var city = _self.infoList.area.split('-')[1];
                var qu = _self.infoList.area.split('-')[2];
                for (var i = 0; i < $('#loc_province option').length; i++) {
                    if ($('#loc_province option')[i].innerHTML == province) {
                        $('#loc_province').select2('val', [$('#loc_province option')[i].value]);
                    }
                }
                for (var i = 0; i < $('#loc_city option').length; i++) {
                    if ($('#loc_city option')[i].innerHTML == city) {
                        $('#loc_city').select2('val', [$('#loc_city option')[i].value]);
                    }
                }
                for (var i = 0; i < $('#loc_town option').length; i++) {
                    if ($('#loc_town option')[i].innerHTML == qu) {
                        $('#loc_town').select2('val', [$('#loc_town option')[i].value]);
                    }
                }
            }
            $("#modalInfo").modal({ backdrop: 'static', keyboard: false });
        },
        infoClose: function () {
            var _self = this;
            $('#modalInfo').on('hide.bs.modal', function () {
                if (_self.infoList.name == _self.list.name && _self.infoList.telephone == _self.list.telephone && _self.infoList.email == _self.list.email && _self.infoList.postcode == _self.list.postcode && _self.infoList.address == _self.list.address) {
                    return true;
                } else {
                    swal("数据修改但没有保存");
                }
            })
        },
        infoSave: function () {
            var _self = this;
            //完善信息/org/modify
            $.ajax({
                type: 'post',
                dataType: 'json',
                contentType: "application/json; charset=utf-8;",
                xhrFields: {
                    //设置跨域请求
                    withCredentials: true
                },
                async: false,
                url: jQuery.url + '/org/modify',
                data: JSON.stringify({
                    id: _self.org.id,//主键
                    name: _self.infoList.name,//名称
                    contact: _self.infoList.contact,//联系人
                    telephone: _self.infoList.telephone,//联系电话
                    email: _self.infoList.email,//邮箱
                    postcode: _self.infoList.postcode,//邮编
                    area: $('#loc_province').select2('data')[0].text + '-' + $('#loc_city').select2('data')[0].text + '-' + $('#loc_town').select2('data')[0].text,//地区
                    address: _self.infoList.address,//详细地址

                }),
                headers: {
                    'token': _self.token,
                },
                success: function (data) {
                    console.log(data.data);
                    if (data.code == 0) {//修改成功重新获取数据
                        _self.getOrg();
                        swal("", "数据修改成功", "success");
                        $('#modalInfo').modal('hide');
                    } else {
                        swal("",data.msg,"error")
                    }
                },
                err: function (err) {
                    swal("",err,"error")
                }
            });
        },
        secretOpen: function () {
            this.passwordModel = "";
            this.passwordcheckModel = "";
            $('#modalSecret').modal({ backdrop: 'static', keyboard: false });
        },
        secretSave: function () {
            var _self = this;
            if (this.passwordValidate.errorText == "" && this.passwordCheckValidate.errorText == "") {
                ///user/modifyPwd 验证通过修改密码
                $.ajax({
                    type: 'post',
                    dataType: 'json',
                    contentType: "application/json; charset=utf-8;",
                    xhrFields: {
                        //设置跨域请求
                        withCredentials: true
                    },
                    async: false,
                    url: jQuery.url + '/user/modifyPwd',
                    data: JSON.stringify({
                        "newPassword": _self.passwordModel,
                        "oldPassword": localStorage.getItem("password")
                    }),
                    headers: {
                        'token': _self.token,
                    },
                    success: function (data) {
                        console.log(data.data);
                        if (data.code == 0) {
                            swal('', '修改成功，请重新登录', 'success');
                            setTimeout(() => {
                                location.href = '../login.html';
                            }, 3000);
                        } else {
                            swal('', '修改失败', 'error');
                        }
                    },
                    err: function (err) {
                          swal("",err,"error")
                    }
                });
            }
        }
    },
    computed: {
        infoListOk: function () {
            if (!this.infoList.name || !this.infoList.telephone || !this.infoList.email || !this.infoList.postcode || !this.infoList.address) {
                return true
            } else if ($('#loc_province').select2('data')[0].text == '省份') {
                return true
            } else {
                return false
            }
        },
        secretShow: function () {
            var _self = this;
            return _self.secretList.secret == _self.secretList.secretAgain || _self.secretList.secret == "" || _self.secretList.secretAgain == "";
        },
        passwordValidate: function () {
            var errorText;
            if (!/^[0-9A-Za-z]{6,15}$/.test(this.passwordModel)) {
                errorText = '密码少于6位'
            } else {
                errorText = ''
            }
            if (!this.passwordFlag) {
                errorText = ''
                this.passwordFlag = true
            }
            return {
                errorText
            }
        },
        passwordCheckValidate: function () {
            var errorText;
            if (!/^[0-9A-Za-z]{6,15}$/.test(this.passwordcheckModel)) {
                errorText = '密码少于6位'
            } else if (this.passwordcheckModel !== this.passwordModel) {
                errorText = '两次密码不匹配'
            }
            else {
                errorText = ''
            }

            if (!this.passwordFlag) {
                errorText = ''
                this.passwordFlag = true
            }
            return {
                errorText
            }
        }
    },
    created: function () {//实例创建完成后执行的钩子
        this.org = JSON.parse(localStorage.getItem('org'));
        this.user = JSON.parse(localStorage.getItem('user'));
        this.token = JSON.parse(localStorage.getItem('token'));


    },
    mounted: function () {//挂载到页面后执行的钩子
        this.getOrg();
        this.infoClose();
    }
})
var vm = new Vue({
    el: "#settings",
    data: {
        org: JSON.parse(localStorage.getItem('org')),
        user: JSON.parse(localStorage.getItem('user'))
    }
});
