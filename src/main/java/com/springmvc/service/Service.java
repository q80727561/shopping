package com.springmvc.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.springmvc.model.Product;

public class Service {
	// JDBC 驅動及數據
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/shop?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
	String user = "root";
	String password = "root";
	private static final Logger logger = LoggerFactory.getLogger(Service.class);

	public Service() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Product> InquireAll() {
		Connection conn = null;
		Statement stmt = null;
		ArrayList<Product> result = new ArrayList<Product>();
		try {
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT price, name , id FROM product_table";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int price = rs.getInt("price");
				String name = rs.getString("name");
				int id = rs.getInt("id");
				result.add(new Product(name, price, id));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			;
		} finally {

			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
			}

			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
			}
		}
		return result;
	}

	public ArrayList<String> Inquireid(int id) {
		Connection conn = null;
		Statement stmt = null;
		ArrayList<String> result = new ArrayList<String>();
		try {
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT price, name , detail FROM product_table WHERE id ='" + id + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				result.add(rs.getString("name"));
				result.add(rs.getString("price"));
				result.add(rs.getString("detail"));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			;
		} finally {

			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
			}

			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
			}
		}
		return result;
	}

}
