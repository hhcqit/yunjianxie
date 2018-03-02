package com.clinicalmall.kuaixiu.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

public class CryptUtils {
	/**
	 * 定义加密算法,可用 DES,DESede,Blowfish
	 */
	public static final String ALGORITHM_DESEDE = "DESede";

	/**
	 * SHA-1运算算法
	 */
	public static final String ALGORITHM_SHA1 = "SHA-1";

	/**
	 * MD5运算算法
	 */
	public static final String ALGORITHM_MD5 = "MD5";

	public CryptUtils() {
	}

	/**
	 * SHA-1 摘要计算(byte[]).
	 * 
	 * @param messageBytes
	 *            byte[]
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static byte[] sha1Digest(byte[] messageBytes) throws NoSuchAlgorithmException {
		return MessageDigest.getInstance(ALGORITHM_SHA1).digest(messageBytes);
	}

	/**
	 * SHA-1 摘要计算(string).
	 * 
	 * @param messages
	 *            原始信息，SHA摘要处理时都用utf8编码转换成字节数组。
	 * @return base64编码后的字符串，如果系统不支持SHA1或者不支持utf8编码时则返回null
	 */
	public static String sha1Digest(String messages) {
		try {
			return base64Encode(sha1Digest(messages.getBytes("UTF8")));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * MD5 摘要计算(byte[]).
	 * 
	 * @param messageBytes
	 *            byte[]
	 * @return byte[] 16 bit digest
	 * @throws NoSuchAlgorithmException
	 */
	public static byte[] md5Digest(byte[] messageBytes) throws NoSuchAlgorithmException {
		// MD5 is 16 bit message digest
		return MessageDigest.getInstance(ALGORITHM_MD5).digest(messageBytes);
	}

	/**
	 * MD5 摘要计算(String).
	 * 
	 * @param messages
	 *            原始信息，MD5摘要处理时都用utf8编码转换成字节数组。
	 * @return 16进制编码后的字符串， 如果系统不支持MD5或者不支持utf8编码时则返回null
	 */
	public static String md5Digest(String messages) {
		try {
			return byte2hex(md5Digest(messages.getBytes("UTF8")));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * BASE64 编码.
	 * 
	 * @param src
	 *            String inputed string
	 * @return String returned string
	 */
	public static String base64Encode(String src) {
		try {
			return new String(Base64.encodeBase64(src.getBytes("UTF8")));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * BASE64 编码(byte[]).
	 * 
	 * @param src
	 *            byte[] inputed string
	 * @return String returned string
	 */
	public static String base64Encode(byte[] src) {
		return new String(Base64.encodeBase64(src));
	}

	/**
	 * BASE64 解码.
	 * 
	 * @param src
	 *            String inputed string
	 * @return String returned string
	 */
	public static String base64Decode(String src) {
		return new String(Base64.decodeBase64(src.getBytes()));
	}

	/**
	 * BASE64 解码(to byte[]).
	 * 
	 * @param src
	 *            String inputed string
	 * @return String returned string
	 */
	public static byte[] base64DecodeToBytes(String src) {
		return Base64.decodeBase64(src.getBytes());
	}

	/**
	 * 将对象转换成byte数组，并将其进行base64编码
	 */
	public static String objectToString(Object obj) {
		String str = "";
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			str = base64Encode(baos.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * 对Base64格式的字符串进行解码
	 */
	public static Object stringToObject(String str) {
		Object obj = null;
		try {
			if (StringUtils.isNotEmpty(str)) {
				byte[] base64Bytes = base64DecodeToBytes(str);
				ByteArrayInputStream bais = new ByteArrayInputStream(base64Bytes);
				ObjectInputStream ois = new ObjectInputStream(bais);
				obj = ois.readObject();
			}
		} catch (StreamCorruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return obj;
	}

	/**
	 * 对给定字符进行 URL 编码.
	 * 
	 * @param src
	 *            String
	 * @return String
	 */
	public static String urlEncode(String src) {
		try {
			src = java.net.URLEncoder.encode(src, "UTF8");
			return src;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return src;
	}

	/**
	 * 对给定字符进行 URL 解码
	 * 
	 * @param value
	 *            解码前的字符串
	 * @return 解码后的字符串
	 */
	public static String urlDecode(String value) {
		try {
			return java.net.URLDecoder.decode(value, "UTF8");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return value;
	}

	/**
	 * 转换成十六进制字符串
	 * 
	 * @param bs
	 * @return
	 */
	public static String byte2hex(byte[] bs) {
		StringBuilder hex = new StringBuilder(bs.length * 2);
		for (byte b : bs) {
			if ((b & 0xFF) < 0x10)
				hex.append("0");
			hex.append(Integer.toHexString(b & 0xFF));
		}
		return hex.toString();
	}

	/**
	 * 把十六进制字符串转换成字节数组
	 * 
	 * @param s
	 * @return
	 */
	public static byte[] hex2byte(String s) {
		return hex2byte(s.getBytes());
	}

	/**
	 * 把十六进制字符串转换成字节数组
	 * 
	 * @param bs
	 * @return
	 */
	public static byte[] hex2byte(byte[] bs) {
		if ((bs.length % 2) != 0)
			throw new IllegalArgumentException();
		byte[] b2 = new byte[bs.length / 2];
		for (int n = 0; n < bs.length; n += 2) {
			String item = new String(bs, n, 2);
			b2[n / 2] = (byte) Integer.parseInt(item, 16);
		}
		return b2;
	}

	/**
	 * DES加密
	 * 
	 * @param key
	 *            加密密钥
	 * @param data
	 *            数据
	 * @return des加密后的16进制字符串
	 */
	public static String desEncrypt(String key, String data) {
		return data == null ? null : byte2hex(DesUtil.encrypt(data.getBytes(), key.getBytes(), null));
	}

	/**
	 * DES解密
	 * 
	 * @param key
	 *            解密密钥
	 * @param data
	 *            des加密的16进制字符串
	 * @return 解密后的字符串
	 */
	public static String desDecrypt(String key, String data) {
		return data == null ? null : new String(DesUtil.decrypt(hex2byte(data.getBytes()), key.getBytes(), null));
	}

	/**
	 * 3DES加密
	 * 
	 * @param key
	 *            加密密钥
	 * @param data
	 *            数据
	 * @return 3des加密后的16进制字符串
	 */
	public static String des3Encrypt(String key, String data) {
		return data == null ? null : byte2hex(TripleDesUtil.encrypt(data.getBytes(), key.getBytes(), null));
	}

	/**
	 * 3DES解密
	 * 
	 * @param key
	 *            解密密钥
	 * @param data
	 *            3des加密的16进制字符串
	 * @return 解密后的字符串
	 */
	public static String des3Decrypt(String key, String data) {
		return data == null ? null : new String(TripleDesUtil.decrypt(hex2byte(data.getBytes()), key.getBytes(), null));
	}

	/**
	 * Test crypt
	 * 
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		System.out.println(base64Encode(sha1Digest(new String("111111噢").getBytes("UTF8"))));
		System.out.println(sha1Digest("111111"));
	}
}
