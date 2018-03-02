package com.clinicalmall.kuaixiu.service.redis;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class IDGenerator {

	@Resource
	private ShardedJedisPool shardedJedisPool = null;
	private static ShardedJedisPool jedisPool = null;

	public static final String PATTERN_YYYY = "yyyy";
	public static final String PATTERN_YYYYMM = "yyyyMM";
	public static final String PATTERN_YYYYMMDD = "yyyyMMdd";
	public static final String PATTERN_YYYYMMDDHHMM = "yyyyMMddHHmm";

	private static final int MAX_SEQUENCE_LENTH = 20;// 最大序列号长度
	private static final String KEY_PREFIX_SEQUENCE = "SEQUENCE_";
	private static final Map<String, SimpleDateFormat> commonDateFormats = new HashMap<String, SimpleDateFormat>();
	private static final List<DecimalFormat> sequenceFormats = new ArrayList<DecimalFormat>();

	static {
		commonDateFormats.put(PATTERN_YYYY, new SimpleDateFormat(PATTERN_YYYY));
		commonDateFormats.put(PATTERN_YYYYMM, new SimpleDateFormat(
				PATTERN_YYYYMM));
		commonDateFormats.put(PATTERN_YYYYMMDD, new SimpleDateFormat(
				PATTERN_YYYYMMDD));
		commonDateFormats.put(PATTERN_YYYYMMDDHHMM, new SimpleDateFormat(
				PATTERN_YYYYMMDDHHMM));
		StringBuilder sequencePattern = new StringBuilder(MAX_SEQUENCE_LENTH);
		for (int i = 0; i < MAX_SEQUENCE_LENTH; i++) {
			sequencePattern.append("0");
			sequenceFormats.add(new DecimalFormat(sequencePattern.toString()));
		}
	}

	@PostConstruct
	private void init() {
		IDGenerator.jedisPool = this.shardedJedisPool;
	}

	/**
	 * 生成主键
	 * 
	 * @param sequenceName
	 *            序列名
	 * @return
	 */
	public static long gen(String sequenceName) {
		ShardedJedis jedis = jedisPool.getResource();
		try {
			long sequence = jedis.incr(KEY_PREFIX_SEQUENCE + sequenceName);
			return sequence;
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}

	/**
	 * 生成主键
	 * 
	 * @param prefix
	 *            前缀，为空
	 * @param pattern
	 *            时间戳格式，为空或null时不使用时间戳
	 * @param sequenceLenth
	 *            序列长度，大于0时有效
	 * @param sequenceName
	 *            序列名
	 * @return prefix+timestamp+sequence
	 */
	public static String gen(String prefix, String pattern, int sequenceLenth,
			String sequenceName) {
		StringBuilder ids = new StringBuilder();
		if (!isEmpty(prefix))
			ids.append(prefix);
		String timestamp = null;
		if (!isEmpty(pattern))
			timestamp = getFormatedDate(pattern);
		if (timestamp != null)
			ids.append(timestamp);
		long sequence = gen(sequenceName);
		if (sequenceLenth > 0) {
			if (sequenceLenth > MAX_SEQUENCE_LENTH)
				sequenceLenth = MAX_SEQUENCE_LENTH;
			String formatSequence = sequenceFormats.get(sequenceLenth - 1)
					.format(sequence);
			if (formatSequence.length() > sequenceLenth)
				formatSequence = formatSequence.substring(formatSequence
						.length() - sequenceLenth);
			ids.append(formatSequence);
		} else
			ids.append(sequence);
		return ids.toString();
	}

	private static String getFormatedDate(String pattern) {
		java.text.SimpleDateFormat sdf = commonDateFormats.get(pattern);
		if (sdf == null)
			try {
				sdf = new java.text.SimpleDateFormat(pattern);
			} catch (Exception e) {
				e.printStackTrace();
			}
		if (sdf == null)
			return null;
		java.util.Date now = new java.util.Date();
		return sdf.format(now);
	}

	private static boolean isEmpty(String str) {
		if (str == null || str.trim().isEmpty())
			return true;
		return false;
	}

}
