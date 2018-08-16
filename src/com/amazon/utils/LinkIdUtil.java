package com.amazon.utils;

import java.util.Arrays;
import java.util.LinkedList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class LinkIdUtil {
	public String linkID(String id, HttpServletRequest req) {
		// 1.加入第一次访问访问图书列表，也就是说没有Cookie,那么直接返回id
		Cookie[] cookies = req.getCookies();
		if (cookies == null) {
			return id;
		}

		 //2.存在的cookie,但没有名字为histroyrecord的cookie
		Cookie historyCookie = null;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("histroyrecord")) {
				historyCookie = cookie;
				break;
			}
		}

		if (historyCookie == null) {
			return id;
		}

		// 3.找到对应的cookie
		String value = historyCookie.getValue();// 可能就是1，或者1-2-3
		/*
		 * 拼接的情况 1.长度小于4，没有冲突的情况，直接放在头部，比如：1-2-3 ，访问4 ，结果：4-1-2-3
		 * 2.长度小于4，有冲突的情况，先删除存在的编号，再把编号添加到头部, 比如: 1-2-3 访问2 结果:2-1-3 3.长度等于4.
		 * 有冲突的情况，先删除存在的编号，再把编号添加到头部, 比如: 1-2-3-4 访问2 结果:2-1-3-4
		 * 4.长度等于4，没有冲突的情况，删除最后一个，把编号放到头部，比如：1-2-3-4 访问5 结果： 5-1-2-3
		 * 
		 */

		// 把数组中转换成一个集合，再把集合放到LinkedList中
		LinkedList<String> list = new LinkedList<>(Arrays.asList(value.split("-")));
		if (list.size() < 4) {
			// 代表冲突
			if (list.contains(id)) {
				list.remove(id);// 删除
			}
		}

		if (list.size() >= 4) {
			// 代表冲突
			if (list.contains(id)) {
				list.remove(id);// 删除
			} else {
				list.removeLast();// 删除最后一个
			}
		}

		// 把编号放到头部
		list.addFirst(id);

		// 拼接id字符串，比如 1-2-3-4
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			if (i > 0) {
				sb.append("-");
			}
			sb.append(list.get(i));
		}
		return sb.toString();
	}
}
