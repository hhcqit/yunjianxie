package com.clinicalmall.kuaixiu.common.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class RandomCodeGenerator {
	public static int numericCode(int length) {
		return RandomUtils.nextInt((int) Math.pow(10, length - 1),
				(int) Math.pow(10, length));
	}

	public static String alphabeticCode(int length) {
		return RandomStringUtils.randomAlphabetic(length);
	}

	public static String alphanumericCode(int length) {
		return RandomStringUtils.randomAlphanumeric(length);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(RandomStringUtils.randomNumeric(6));
			System.out.println(RandomStringUtils.random(6,
					"abcdefghijkmnpqrstuvwxyz"));
			System.out.println(numericCode(8));
		}
	}
}
