package com.example.dm_demo.util;


import org.springframework.http.HttpStatus;

import java.util.HashMap;

/**
 * @author chenmin
 * @date 2019/7/31 14:46
 */
public class Result extends HashMap<String, Object> {

	private static final long serialVersionUID = 1L;

	/**
	 * 状态码
	 */
	private static final String CODE_TAG = "code";

	/**
	 * 返回内容
	 */
	private static final String MSG_TAG = "msg";

	/**
	 * 数据对象
	 */
	private static final String DATA_TAG = "data";

	/**
	 * 初始化一个新创建的 Result 对象，使其表示一个空消息。
	 */
	public Result() {
	}

	/**
	 * 初始化一个新创建的 Result 对象
	 * @param code 状态码
	 * @param msg 返回内容
	 */
	public Result(int code, String msg) {
		super.put(CODE_TAG, code);
		super.put(MSG_TAG, msg);
	}

	/**
	 * 初始化一个新创建的 Result 对象
	 * @param code 状态码
	 * @param msg 返回内容
	 * @param data 数据对象
	 */
	public Result(int code, String msg, Object data) {
		super.put(CODE_TAG, code);
		super.put(MSG_TAG, msg);
		if (data != null) {
			super.put(DATA_TAG, data);
		}
	}

	/**
	 * 返回成功消息
	 * @return 成功消息
	 */
	public static Result success() {
		return Result.success("success");
	}

	/**
	 * 返回成功数据
	 * @return 成功消息
	 */
	public static Result success(Object data) {
		return Result.success("success", data);
	}

	/**
	 * 返回成功消息
	 * @param msg 返回内容
	 * @return 成功消息
	 */
	public static Result success(String msg) {
		return Result.success(msg, null);
	}

	/**
	 * 返回成功消息
	 * @param msg 返回内容
	 * @param data 数据对象
	 * @return 成功消息
	 */
	public static Result success(String msg, Object data) {
		return new Result(HttpStatus.OK.value(), msg, data);
	}

	/**
	 * 返回错误消息
	 */
	public static Result error() {
		return Result.error("fail");
	}

	/**
	 * 返回错误消息
	 * @param msg 返回内容
	 * @return 警告消息
	 */
	public static Result error(String msg) {
		return Result.error(msg, null);
	}

	/**
	 * 返回错误消息
	 * @param msg 返回内容
	 * @param data 数据对象
	 * @return 警告消息
	 */
	public static Result error(String msg, Object data) {
		return new Result(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg, data);
	}

	/**
	 * 返回错误消息
	 * @param code 状态码
	 * @param msg 返回内容
	 * @return 警告消息
	 */
	public static Result error(int code, String msg) {
		return new Result(code, msg, null);
	}



}
