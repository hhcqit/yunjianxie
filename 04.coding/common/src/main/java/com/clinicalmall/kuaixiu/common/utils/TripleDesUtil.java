package com.clinicalmall.kuaixiu.common.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class TripleDesUtil {

	/**
	 * 定义加密算法,可用 DES,DESede,Blowfish
	 */
	private static final String ALGORITHM_DESEDE = "DESede";

	/**
	 * 转变方式：DESede/CBC/PKCS5Padding
	 */
	private static final String TRANSFORMATION_DESEDE_CBC = "DESede/CBC/PKCS5Padding";

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

	public static byte[] process(byte[] dataBytes, byte[] keyBytes,
			byte[] ivBytes, int mode) {
		try {
			// 生成密钥
			SecretKey key = new SecretKeySpec(keyBytes, ALGORITHM_DESEDE);
			Cipher cipher = Cipher.getInstance(TRANSFORMATION_DESEDE_CBC,
					"SunJCE");
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

	public static void main(String[] args) throws Exception {
		// 添加新安全算法,如果用JCE就要把它添加进去
		// Security.addProvider(new com.sun.crypto.provider.SunJCE());

		String keyStr = "NSHNy+HKzBXRNmE4zet+/PhbCiwhcZqr";// 32位明文密钥
		final byte[] keyBytes = Base64.decodeBase64(keyStr);// 24字节的密钥
		for (int i = 0; i < keyBytes.length; i++)
			System.out.print(keyBytes[i]);
		System.out.println();
		System.out.println(Base64.encodeBase64String(keyBytes));
		System.out.println(Base64.encodeBase64String(DEFAULT_IV_BYTES));
		String srcStr = "This is a 3DES test+测试";
		srcStr = "SYTEST" + "$" + "1234" + "$" + "KDSW_901" + "$" + "1125";
		byte[] srcBytes = srcStr.getBytes("utf8");
		System.out.println("加密前的字符串:" + srcStr);

		byte[] encoded = encrypt(srcBytes, keyBytes, DEFAULT_IV_BYTES);

		String enStr = new String(Base64.encodeBase64(encoded), "utf8");
		System.out.println("加密后的字符串:" + enStr);

		byte[] deStr = Base64.decodeBase64(enStr);

		byte[] decBytes = decrypt(deStr, keyBytes, DEFAULT_IV_BYTES);
		System.out.println("解密后的字符串:" + (new String(decBytes, "utf8")));

	}
}
