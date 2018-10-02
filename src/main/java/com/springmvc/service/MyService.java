package com.springmvc.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.springmvc.model.Product;

@Service
public class MyService {
	// JDBC 驅動及數據
	@Value("${jdbc_username}")
	String user;
	@Value("${jdbc_password}")
	String password;
	@Value("${jdbc_url}")
	String url;

	private static final Logger logger = LoggerFactory.getLogger(MyService.class);

	public MyService(@Value("${jdbc_driver}") String driver) {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean register(String name, String userpassword) {
		Connection conn = null;
		Statement stmt = null;
		boolean result=true;
		try {
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			String	sql = "INSERT INTO member (username,userpassword) VALUES ('" + name + "','" + userpassword + "')";
			stmt.execute(sql);
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			result=false;
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

	public String LoginCertification(String UserName, String UserPassword) {
		Connection conn = null;
		Statement stmt = null;
		String name = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			String sql = "SELECT username FROM member WHERE username = '" + UserName + "' and userpassword ='"
					+ UserPassword + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				name = rs.getString("username");
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
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
		return name;
	}

	public ArrayList<Product> InquireType(String type) {
		Connection conn = null;
		Statement stmt = null;
		ArrayList<Product> result = new ArrayList<Product>();
		try {
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			String sql = "";
			switch (type) {
			case "tw":
				sql = "SELECT price, name , no FROM product_table WHERE no like '___001___' or no like '___002___'";
				break;
			case "en":
				sql = "SELECT price, name , no FROM product_table WHERE no like '___003___'";
				break;
			case "001":
			case "002":
			case "003":
				sql = "SELECT price, name , no FROM product_table WHERE no like '" + type + "%'";
				break;
			default:
				break;
			}
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int price = rs.getInt("price");
				String name = rs.getString("name");
				String no = rs.getString("no");
				String img = no.substring(0, 3) + "/" + no.substring(3, 6) + "/" + no + ".jpg";
				Product product = new Product();
				product.setName(name);
				product.setPrice(price);
				product.setImg(img);
				product.setNo(no);
				result.add(product);
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
					stmt = null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
			}

			try {
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
			}
		}
		return result;
	}

	public ArrayList<String> Inquireid(String no) {
		Connection conn = null;
		Statement stmt = null;
		ArrayList<String> result = new ArrayList<String>();
		try {
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT price, name , detail FROM product_table WHERE no ='" + no + "'";
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
