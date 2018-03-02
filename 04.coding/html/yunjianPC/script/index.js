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
var vm = new Vue({
    el: "#index",
    data: {
        loginStyle: loginStyle,
        org: JSON.parse(localStorage.getItem('org')),
        user: JSON.parse(localStorage.getItem('user'))
    },
    created: function () {

    }
})