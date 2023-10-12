package com.capgemini.lern2shan.itdebt.controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;


public class jdbcTemplate {
	
	 @Autowired
	    private DataSource dataSource;

	    @Bean
	    public JdbcTemplate jdbcTemplate() {
	        return new JdbcTemplate(dataSource);
	    }

		public static Long queryForObject(String sql, Class<Long> class1, String assetName) {
			// TODO Auto-generated method stub
			return null;
		}

}
