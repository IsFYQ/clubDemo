package com.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 */
public class R extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	
	public R() {
		put("code", 0);
	}

	//默认500服务器错误。
	public static R error() {
		return error(500, "未知异常，请联系管理员");
	}

	//返回指定消息的状态500服务器错误
	public static R error(String msg) {
		return error(500, msg);
	}

	//返回带有指定代码和消息的错误状态
	public static R error(int code, String msg) {
		R r = new R();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	//返回带有指定消息的成功状态
	public static R ok(String msg) {
		R r = new R();
		r.put("msg", msg);
		return r;
	}

	//返回带有指定映射map的成功状态
	public static R ok(Map<String, Object> map) {
		R r = new R();
		r.putAll(map);
		return r;
	}

	//返回空成功状态
	public static R ok() {
		return new R();
	}

	//像hashmap一样在此类中添加键值对，这些添加后的键值对都将输出到客户端响应
	public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
