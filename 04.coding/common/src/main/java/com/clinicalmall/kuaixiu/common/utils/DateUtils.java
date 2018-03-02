package com.clinicalmall.kuaixiu.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	private final static ThreadLocal<SimpleDateFormat> timestampFormater = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINESE);
		}
	};
	/**
	 * yyyyMMddHHmmss
	 */
	private final static ThreadLocal<SimpleDateFormat> timestampFormater2 = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMddHHmmss", Locale.CHINESE);
		}
	};
	/**
	 * yyyyMMdd
	 */
	private final static ThreadLocal<SimpleDateFormat> dateFormaterWithyyyyMMdd = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMdd", Locale.CHINESE);
		}
	};
	/**
	 * yyyy-MM-dd
	 */
	private final static ThreadLocal<SimpleDateFormat> dateFormater = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE);
		}
	};
	/**
	 * yyyyMM
	 */
	private final static ThreadLocal<SimpleDateFormat> dateFormaterWithyyyyMM = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyyMM", Locale.CHINESE);
		}
	};
	/**
	 * yyyy-MM
	 */
	private final static ThreadLocal<SimpleDateFormat> dateFormaterWithyyyy_MM = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM", Locale.CHINESE);
		}
	};
	/**
	 * MMdd
	 */
	private final static ThreadLocal<SimpleDateFormat> dateFormaterWithMMdd = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("MMdd", Locale.CHINESE);
		}
	};
	/**
	 * MM-dd
	 */
	private final static ThreadLocal<SimpleDateFormat> dateFormaterWithMM_dd = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("MM-dd", Locale.CHINESE);
		}
	};
	/**
	 * HH:mm:ss
	 */
	private final static ThreadLocal<SimpleDateFormat> timeFormater = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("HH:mm:ss", Locale.CHINESE);
		}
	};
	/**
	 * HH:mm
	 */
	private final static ThreadLocal<SimpleDateFormat> timeFormaterWithHHmm = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("HH:mm", Locale.CHINESE);
		}
	};

	/**
	 * 返回格式为yyyy-MM-dd HH:mm:ss时间字符串
	 * 
	 * @return 时间字符串
	 */
	public static String genCurrentTimestamp() {
		return timestampFormater.get().format(new Date());
	}

	/**
	 * 返回格式为{@link #timestampFormater2}时间字符串
	 * 
	 * @return 时间字符串
	 */
	public static String genCurrentTimestamp2() {
		return timestampFormater2.get().format(new Date());
	}

	/**
	 * 返回格式为yyyy-MM-dd日期字符串
	 * 
	 * @return 日期字符串
	 */
	public static String genCurrentDate() {
		return dateFormater.get().format(new Date());
	}

	/**
	 * 返回格式为yyyyMMdd日期字符串
	 * 
	 * @return 日期字符串
	 */
	public static String genCurrentDateWithyyyyMMdd() {
		return dateFormaterWithyyyyMMdd.get().format(new Date());
	}

	/**
	 * 返回格式为 HH:mm:ss时间字符串
	 * 
	 * @return 时间字符串
	 */
	public static String formatCurrentTime() {
		return timeFormater.get().format(new Date());
	}

	/**
	 * 
	 * @param template
	 *            自定义格式
	 * @param date
	 * @return
	 */
	public static String format(String template, Date date) {
		return new SimpleDateFormat(template, Locale.CHINESE).format(date);
	}

	/**
	 * 
	 * @param date
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String format(Date date) {
		return timestampFormater.get().format(date);
	}

	/**
	 * 
	 * @param date
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String format(long date) {
		return timestampFormater.get().format(new Date(date));
	}

	public static String formatCurrentTime(String template) {
		return format(template, new Date());
	}

	/**
	 * 
	 * @param date
	 * @return yyyy-MM-dd
	 */
	public static String formatDate(Date date) {
		return dateFormater.get().format(date);
	}

	/**
	 * 
	 * @param date
	 * @return yyyy-MM-dd 周几
	 */
	public static String formatDateAndWeek(Date date) {
		return new StringBuilder(formatDate(date)).append(" ")
				.append(formatWeek(date)).toString();
	}

	/**
	 * 
	 * @param date
	 * @return yyyyMMdd
	 */
	public static String formatDateWithyyyyMMdd(Date date) {
		return dateFormaterWithyyyyMMdd.get().format(date);
	}

	/**
	 * 
	 * @param date
	 * @return yyyyMM
	 */
	public static String formatDateWithyyyyMM(Date date) {
		return dateFormaterWithyyyyMM.get().format(date);
	}

	/**
	 * 
	 * @param date
	 * @return yyyy-MM
	 */
	public static String formatDateWithyyyy_MM(Date date) {
		return dateFormaterWithyyyy_MM.get().format(date);
	}

	/**
	 * 
	 * @param date
	 * @return MMdd
	 */
	public static String formatDateWithMMdd(Date date) {
		return dateFormaterWithMMdd.get().format(date);
	}

	/**
	 * 
	 * @param date
	 * @return MM-dd
	 */
	public static String formatDateWithMM_dd(Date date) {
		return dateFormaterWithMM_dd.get().format(date);
	}

	/**
	 * 
	 * @param date
	 * @return yyyy-MM-dd
	 */
	public static String formatDate(long date) {
		return formatDate(new Date(date));
	}

	/**
	 * 
	 * @param date
	 * @return yyyy-MM-dd 周几
	 */
	public static String formatDateAndWeek(long date) {
		return formatDateAndWeek(new Date(date));
	}

	/**
	 * 
	 * @param date
	 * @return yyyyMMdd
	 */
	public static String formatDateWithyyyyMMdd(long date) {
		return dateFormaterWithyyyyMMdd.get().format(new Date(date));
	}

	/**
	 * 
	 * @param date
	 * @return yyyyMM
	 */
	public static String formatDateWithyyyyMM(long date) {
		return formatDateWithyyyyMM(new Date(date));
	}

	/**
	 * 
	 * @param date
	 * @return yyyy-MM
	 */
	public static String formatDateWithyyyy_MM(long date) {
		return formatDateWithyyyy_MM(new Date(date));
	}

	// time

	/**
	 * 
	 * @param time
	 * @return HH:mm:ss
	 */
	public static String formatTime(Date time) {
		return timeFormater.get().format(time);
	}

	/**
	 * 
	 * @param time
	 * @return HH:mm:ss
	 */
	public static String formatTime(long time) {
		return timeFormater.get().format(new Date(time));
	}

	/**
	 * 
	 * @param time
	 * @return HH:mm
	 */
	public static String formatTimeWithHHmm(Date time) {
		return timeFormaterWithHHmm.get().format(time);
	}

	/**
	 * 
	 * @param time
	 * @return HH:mm
	 */
	public static String formatTimeWithHHmm(long time) {
		return timeFormaterWithHHmm.get().format(new Date(time));
	}

	/**
	 * 
	 * @param template
	 *            自定义格式
	 * @param date
	 * @return
	 */
	public static Date parse(String template, String time) {
		if (time == null || time.trim().equals(""))
			return null;
		try {
			return new SimpleDateFormat(template, Locale.CHINESE).parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param date
	 *            yyyy-MM-dd
	 * @return
	 */
	public static Date parseDate(String date) {
		try {
			return dateFormater.get().parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param date
	 *            yyyyMMdd
	 * @return
	 */
	public static Date parseDateWithyyyyMMdd(String date) {
		try {
			return dateFormaterWithyyyyMMdd.get().parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param time
	 *            HH:mm:ss
	 * 
	 * @return
	 */
	public static Date parseTime(String time) {
		try {
			return timeFormater.get().parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param time
	 *            yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static Date parseTimestamp(String time) {
		try {
			return timestampFormater.get().parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param time
	 *            yyyyMMddHHmmss
	 * 
	 * @return
	 */
	public static Date parseTimestamp2(String time) {
		try {
			return timestampFormater2.get().parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String formatWeek(long date) {
		return formatWeek(new Date(date));
	}

	public static String formatWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return formatWeek(calendar.get(Calendar.DAY_OF_WEEK));
	}

	private static String formatWeek(int week) {
		switch (week) {
		case Calendar.MONDAY:
			return "周一";
		case Calendar.TUESDAY:
			return "周二";
		case Calendar.WEDNESDAY:
			return "周三";
		case Calendar.THURSDAY:
			return "周四";
		case Calendar.FRIDAY:
			return "周五";
		case Calendar.SATURDAY:
			return "周六";
		default:
			return "周日";
		}
	}
}
