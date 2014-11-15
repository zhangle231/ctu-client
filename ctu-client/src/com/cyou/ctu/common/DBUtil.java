package com.cyou.ctu.common;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class DBUtil {
	private JdbcTemplate jdbcTemplate;

	public void getDB() {
		System.out.println("get DB.");
		List<String> userName = this.jdbcTemplate.query("select * from Users", 
				new RowMapper<String>(){
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

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
}
