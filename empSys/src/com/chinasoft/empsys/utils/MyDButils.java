package com.chinasoft.empsys.utils;



import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 *数据库的c3p0连接
 */
public class MyDButils {
	/**
	 * MyDButils私有空参构造方法
	 */
	private MyDButils() {
		
	}
	public static ComboPooledDataSource getDataSource() {
		ComboPooledDataSource dataSource=new ComboPooledDataSource();
		return dataSource;
	}
	public static Connection getConnection() {
		try {
			return getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
