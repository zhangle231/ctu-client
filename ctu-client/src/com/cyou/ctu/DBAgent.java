package com.cyou.ctu;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cyou.ctu.common.DBUtil;
import com.cyou.ctu.common.spring.DBContextHolder;

public class DBAgent {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "beans.xml" });
		
		DBUtil dbUtil = ctx.getBean("dbUtil", DBUtil.class);
		dbUtil.getDB();
		ctx.close();
	}

}
