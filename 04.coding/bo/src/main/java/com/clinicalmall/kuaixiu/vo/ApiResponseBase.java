package com.clinicalmall.kuaixiu.vo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ApiResponseBase<T> implements Serializable {
	public static final int CODE_SUCCESSFUL = 0;
	public static final int CODE_INVALID_SESSION = 1;
	public static final int CODE_FAILED = 2;
	public static final int CODE_INVALID_PARAMETER = 3;
	public static final int CODE_INVALID_USER = 10;
	public static final int CODE_INVALID_PASSWORD = 11;
	public static final int CODE_INVALID_TASK = 50;
	public static final int CODE_INVALID_TASK_STATUS = 51;

	/**
	 * 
	 */
	private static final long serialVersionUID = 8195934080392616339L;
	private int code = CODE_SUCCESSFUL;
	private String msg;
	private int pageNumber;
	private int pageSize;
	private int totalRow;
	private T data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
