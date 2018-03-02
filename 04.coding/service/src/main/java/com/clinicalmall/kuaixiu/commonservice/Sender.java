package com.clinicalmall.kuaixiu.commonservice;

import java.io.*;
import java.net.*;

public class Sender {

	public Sender() {
		this("renjunwang", "men007");
	}

	public Sender(String name, String pwd) {
		comName = name;
		comPwd = pwd;
		Server = "http://203.81.21.34";
	}

	public Sender(String name, String pwd, int serverNum) {
		comName = name;
		comPwd = pwd;
		if (serverNum == 2)
			Server = "http://www6.china-sms.com";
		else
			Server = "http://203.81.21.34";
	}

	public String massSend(String dst, String msg, String time, String subNo) throws UnsupportedEncodingException {
		String sUrl = null;
		try {
			sUrl = Server + "/send/gsend.asp?name=" + comName + "&pwd=" + comPwd + "&dst=" + dst + "&msg="
					+ URLEncoder.encode(msg, "GB2312") + "&time=" + time + "&sender=" + subNo;// 这里必须GB2312否则发到手机乱码
		} catch (UnsupportedEncodingException uee) {
			System.out.println(uee.toString());
		}
		return getUrl(sUrl);
	}

	public String readSms() throws UnsupportedEncodingException {
		String sUrl = null;
		sUrl = Server + "/send/readsms.asp?name=" + comName + "&pwd=" + comPwd;
		try {
			URLEncoder.encode(sUrl, "GB2312");
		} catch (UnsupportedEncodingException uee) {
			System.out.println(uee.toString());
		}
		return getUrl(sUrl);
	}

	public String getFee() throws UnsupportedEncodingException {
		String sUrl = null;
		sUrl = Server + "/send/getfee.asp?name=" + comName + "&pwd=" + comPwd;
		return getUrl(sUrl);
	}

	public String changePwd(String newPwd) throws UnsupportedEncodingException {
		String sUrl = null;
		sUrl = Server + "/send/cpwd.asp?name=" + comName + "&pwd=" + comPwd + "&newpwd=" + newPwd;
		try {
			URLEncoder.encode(sUrl, "GB2312");
		} catch (UnsupportedEncodingException uee) {
			System.out.println(uee.toString());
		}
		return getUrl(sUrl);
	}

	public String checkContent(String content) throws UnsupportedEncodingException {
		String sUrl = null;
		sUrl = Server + "/send/checkcontent.asp?name=" + comName + "&pwd=" + comPwd + "&content=" + content;
		try {
			URLEncoder.encode(sUrl, "GB2312");
		} catch (UnsupportedEncodingException uee) {
			System.out.println(uee.toString());
		}
		return getUrl(sUrl);
	}

	public String getUrl(String urlString) throws UnsupportedEncodingException {
		StringBuffer sb = new StringBuffer();
		try {
			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			for (String line = null; (line = reader.readLine()) != null;)
				sb.append(line + "\n");

			reader.close();
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		String msg = sb.toString();
		return new String(msg.getBytes("GBK"), "GB2312");
	}

	/*
	 *参数说明：
	 * dst - 手机号之间用英文逗号分割,最后一个手机号后不加逗号, 必填, 小灵通号码发送请和手机号码分离单独作为一组发送。请少于100个号码。
	 * msg - 短信内容，为不超过60个汉字、字符、数字的字符串，小灵通号码不超过40个字。超过的字符自动截掉。如果是超长短信，不能超过240个字符。 
	 * time - 定时时间(可不填)，例如“200505241713”表示此条短信定时在2005年5月24日17点13分发出。 格式: YYYYMMDDHHMM；12位时间表示，不符合规则的将立即进行发送。 
	 * subNo - 子号码(可不填)，例如您的特服代码为0888008，想让此条短信的发送者为088800800，则sender=00即可；值为空则默认为您的特服代码。
	 * */
	public static String smsSend(String dst, String msg, String time, String subNo)
			throws UnsupportedEncodingException {
		String sUrl = null;
		String comName = "renjunwang";
		String comPwd = "men007";
		String Server = "http://203.81.21.34";
		try {
			sUrl = Server + "/send/gsend.asp?name=" + comName + "&pwd=" + comPwd + "&dst=" + dst + "&msg="
					+ URLEncoder.encode(msg, "GB2312") + "&time=" + time + "&sender=" + subNo;// 这里必须GB2312否则发到手机乱码
		} catch (UnsupportedEncodingException uee) {
			System.out.println(uee.toString());
		}
		return getUrlMsg(sUrl);
	}

	/*
	 * 发送短信并且回传数据
	 * 
	 */
	public static String getUrlMsg(String urlString) throws UnsupportedEncodingException {
		StringBuffer sb = new StringBuffer();
		try {
			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			for (String line = null; (line = reader.readLine()) != null;)
				sb.append(line + "\n");

			reader.close();
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		String msg = sb.toString();
		return new String(msg.getBytes("GBK"), "GB2312");
	}

	private String comName = "renjunwang";
	private String comPwd = "men007";
	private String Server = "http://203.81.21.34";
}