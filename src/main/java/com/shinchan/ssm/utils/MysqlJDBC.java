package com.shinchan.ssm.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MysqlJDBC {
	private ResourceBundle resource;
	private static String driver;
	private static String url;
	private static String user;
	private static String password;

	public MysqlJDBC() {
		ResourceBundle resource = ResourceBundle.getBundle("jdbc");
		driver = resource.getString("driver");
		url = resource.getString("url");
		user = resource.getString("userName");
		password = resource.getString("passWord");
	}

	/**
	 * 获取数据库连接
	 * @return conn 数据库连接
	 */
	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("'com.mysql.jdbc.Driver' 驱动未找到!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接失败!");
		}
		return conn;
	}

	/**
	 * 关闭数据库连接
	 * @param rs 结果集对象
	 * @param ps 预编译对象
	 * @param conn 数据库连接对象
	 */
	public void closeConn(ResultSet rs, PreparedStatement ps, Connection conn) {

		try {
			if (rs != null) {// 如果返回的结果集对象不能为空,就关闭连接
				rs.close();
			}
			if (ps != null) {
				ps.close();// 关闭预编译对象
			}
			if (conn != null) {
				conn.close();// 关闭数据库连接对象
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
