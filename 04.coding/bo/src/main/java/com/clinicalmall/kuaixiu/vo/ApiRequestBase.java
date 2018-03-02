package com.clinicalmall.kuaixiu.vo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ApiRequestBase<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4077065696147203479L;

	private String token;
	private int pageNumber;
	private int pageSize;
	private T data;

	public ApiRequestBase() {
	}

	public ApiRequestBase(String token) {
		this.token = token;
	}

	public ApiRequestBase(T data) {
		this.data = data;
	}

	public ApiRequestBase(String token, T data) {
		this.token = token;
		this.data = data;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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
