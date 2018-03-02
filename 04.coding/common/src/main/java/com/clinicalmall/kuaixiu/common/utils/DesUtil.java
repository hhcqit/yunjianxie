package com.clinicalmall.kuaixiu.common.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class DesUtil {

	/**
	 * 定义加密算法,可用 DES,DESede,Blowfish
	 */
	private static final String ALGORITHM_DES = "DES";

	/**
	 * 转变方式：DESede/CBC/PKCS5Padding
	 */
	private static final String TRANSFORMATION_DES_CBC = "DES/CBC/PKCS5Padding";

	/**
	 * 默认初始向量
	 */
	private static final byte[] DEFAULT_IV_BYTES = new byte[] { 1, 2, 3, 4, 5,
			6, 7, 8 };

	/**
	 * 加密模式
	 * 
	 * @param dataBytes
	 *            需要加密的数据
	 * @param keyBytes
	 *            密钥，长度为24字节
	 * @param ivBytes
	 *            Initial Vector,长度为8字节。如果为null，将使用工具默认的初始向量
	 * @return
	 */
	public static byte[] encrypt(byte[] dataBytes, byte[] keyBytes,
			byte[] ivBytes) {
		return process(dataBytes, keyBytes, ivBytes, Cipher.ENCRYPT_MODE);
	}

	/**
	 * 解密模式
	 * 
	 * @param dataBytes
	 *            需要解密的数据
	 * @param keyBytes
	 *            密钥，长度为24字节
	 * @param ivBytes
	 *            Initial Vector,长度为8字节。如果为null，将使用工具默认的初始向量
	 * @return
	 */
	public static byte[] decrypt(byte[] dataBytes, byte[] keyBytes,
			byte[] ivBytes) {
		return process(dataBytes, keyBytes, ivBytes, Cipher.DECRYPT_MODE);
	}

	private static byte[] process(byte[] dataBytes, byte[] keyBytes,
			byte[] ivBytes, int mode) {
		try {
			// 生成密钥
			SecretKey key = new SecretKeySpec(keyBytes, ALGORITHM_DES);
			Cipher cipher = Cipher
					.getInstance(TRANSFORMATION_DES_CBC, "SunJCE");
			IvParameterSpec iv = new IvParameterSpec(
					ivBytes == null ? DEFAULT_IV_BYTES : ivBytes);
			cipher.init(mode, key, iv);
			return cipher.doFinal(dataBytes);
		} catch (java.security.NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (java.lang.Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

}
