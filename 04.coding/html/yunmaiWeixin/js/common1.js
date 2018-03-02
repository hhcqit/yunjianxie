mui.ready(function() {
	var docEl = document.documentElement,
		resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',
		clientWidth = docEl.clientWidth,
		clientHeight = docEl.clientHeight;
	if(!clientWidth) return;
	//    console.log(clientWidth);
	//    console.log(clientHeight);
	docEl.style.fontSize = 16 * (clientWidth / 375) + 'px';
});

function padleft0(obj) {
	return obj.toString().replace(/^[0-9]{1}$/, "0" + obj);
}
//封装mui的ajax的 get方式
function getAjax(url, data, successFun) {
	var commURL = "http://wx.ailabcare.com/kuaixiu" + url;
	//var commURL="http://localhost:13728"+url;
	mui.ajax(commURL, {
		data: data,
		dataType: "json",
		type: "get",
		success: successFun,
		error: function(xhr, type, errorThrown) {
			//console.log(commURL);
			if(type == 'timeout') {
				mui.alert("请求超时：请检查网络")
			} else {
				mui.alert('请求失败：' + type + '\n err:' + errorThrown);
			}
			mui.alert(commURL + "失败");
		}
	});
}

//封装mui的ajax的 post方式
function postAjax(url, data, successFun) {
	var commURL = "http://wx.ailabcare.com/kuaixiu" + url;
	mui.ajax(commURL, {
		data: data,
		//dataType:"application/json",
		type: "post",
		crossDomainRequest: true,
		dataType: "json",
		timeout: 15000000,
		//headers: { "Content-Type": "application/x-www-form-urlencoded" },
		success: successFun,
		error: function(xhr, type, errorThrown) {
			//mui.alert(commURL + "失败");
			console.log(commURL);
			mui.alert("请求失败！请检查网络！" + errorThrown + "---" + type)
		}
	});
}

function byID(id) {
	return document.getElementById(id);
}
//获得时间yyyymmddhhmmss   "20170228205923"
function getnowtime() {
	var nowtime = new Date();
	var year = nowtime.getFullYear();
	var month = padleft0(nowtime.getMonth() + 1);
	var day = padleft0(nowtime.getDate());
	var hour = padleft0(nowtime.getHours());
	var minute = padleft0(nowtime.getMinutes());
	var second = padleft0(nowtime.getSeconds());
	return year + month + day + hour + minute + second;
}

//获得当前时间yy-mm-dd
function getNowFormatDate() {
	var date = new Date();
	var seperator1 = "-";
	var year = date.getFullYear();
	var month = date.getMonth() + 1;
	var strDate = date.getDate();
	if(month >= 1 && month <= 9) {
		month = "0" + month;
	}
	if(strDate >= 0 && strDate <= 9) {
		strDate = "0" + strDate;
	}
	var currentdate = year + seperator1 + month + seperator1 + strDate;
	return currentdate;
}

//将对象转换为键值对
function objToStr(man) {
	var arr = [];
	for(var i in man) {
		if(Object.prototype.hasOwnProperty.call(man, i)) { //过滤
			//			console.log(i+":"+man[i]);
			arr.push(i + '=' + man[i]);
		}
	}
	return arr.join('&');
}

//两端去空格函数
String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
}

function lookData(data) {
	console.log(JSON.stringify(data));
}

function notice(URL) {
	var context = plus.android.runtimeMainActivity();
	var RingtoneManager = plus.android.importClass('android.media.RingtoneManager');
	//var uri = RingtoneManager.getActualDefaultRingtoneUri(context,RingtoneManager.TYPE_RINGTONE);
	var uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
	plus.android.importClass(uri);
	//var p = plus.audio.createPlayer('uri.toString() ');
	var p = plus.audio.createPlayer(URL);
	p.play(function() {
		alert("Audio play success!");
	}, function(e) {
		alert("Audio play error: " + e.message);
	}) 

}

//判断是否是｛｝
function isEmptyObject(e) {
	var t;
	for(t in e)
		return !1;
	return !0
}

// axios.defaults.baseURL = 'http://wx.ailabcare.com/kuaixiu';
jQuery.url =  'http://wx.ailabcare.com/kuaixiu';

$.ajax({
	type: 'post',
	url: jQuery.url + '/user/login',
	data: JSON.stringify({
		"mobile": "18868734635",//18258456811
		"password": "123456"
	}),
	async:false,
	dataType: 'json',
	contentType: "application/json; charset=utf-8",
	xhrFields: {
		//设置跨域请求
		withCredentials: true
	},
	success: function (data) {
		lookData(data);
		if (data.code == 0) {
			localStorage.setItem("loginData",JSON.stringify(data.data));
		} else {
			mui.alert(data.msg);
		}

	},  
	err: function (err) {
		alert(err);
	}
})