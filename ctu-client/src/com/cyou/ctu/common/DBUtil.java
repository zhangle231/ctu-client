package com.cyou.ctu.common;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.cyou.ctu.common.spring.DBContextHolder;

public class DBUtil {
	private JdbcTemplate jdbcTemplate;

	/**
	 * 注入JdbcTemplate
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void getDB() {
		System.out.println("get DB.");
		DBContextHolder.setDBType("dataSource");
		List<String> userName = this.jdbcTemplate.query("select * from Users",
				new RowMapper<String>() {
					@Override
					public String mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						StringBuilder sb = new StringBuilder();
						int columnCount = rs.getMetaData().getColumnCount();
						for (int i = 1; i <= columnCount; i++) {
							sb.append(rs.getObject(i)).append(",");
						}
						return sb.toString();
					}

				});
		System.out.println(userName);
	}
}
