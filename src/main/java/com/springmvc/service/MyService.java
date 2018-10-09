package com.springmvc.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.springmvc.model.Product;
import com.springmvc.model.ShopCart;
import com.springmvc.model.User;

@Service("MyService")
public class MyService {
	// JDBC 驅動及數據
	@Value("${jdbc_username}")
	String jdbcuser;
	@Value("${jdbc_password}")
	String jdbcpassword;
	@Value("${jdbc_url}")
	String jdbcurl;

	private static final Logger logger = LoggerFactory.getLogger(MyService.class);

	public MyService(@Value("${jdbc_driver}") String driver) {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean updataUser(String username, Map<String,ShopCart> shopcartlist) {
		Connection conn = null;
		Statement stmt = null;
		boolean result = true;
		try {
			conn = DriverManager.getConnection(jdbcurl, jdbcuser, jdbcpassword);
			stmt = conn.createStatement();
			String sql = "DELETE FROM shop_cart WHERE username ='" + username + "'";
			stmt.execute(sql);
			if (shopcartlist != null) {
				for (Entry<String, ShopCart> entry : shopcartlist.entrySet()) {
					String sqlstring = "INSERT INTO shop_cart (productno,productnum,username) VALUES ('"
							+ entry.getValue().getProductno() + "','" + entry.getValue().getProductnum() + "','" + username + "')";
					stmt.execute(sqlstring);
				}
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			result = false;
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

	public boolean register(String name, String userpassword) {
		Connection conn = null;
		Statement stmt = null;
		boolean result = true;
		try {
			conn = DriverManager.getConnection(jdbcurl, jdbcuser, jdbcpassword);
			stmt = conn.createStatement();
			String sql = "INSERT INTO member (username,userpassword) VALUES ('" + name + "','" + userpassword + "')";
			stmt.execute(sql);
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			result = false;
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

	public User LoginCertification(String userName, String userPassword) {
		Connection conn = null;
		Statement stmt = null;
		User user = new User();
		try {
			conn = DriverManager.getConnection(jdbcurl, jdbcuser, jdbcpassword);
			stmt = conn.createStatement();
			String sql = "SELECT username , userpassword FROM member WHERE username = '" + userName
					+ "' and userpassword ='" + userPassword + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				user.setUsername(rs.getString("username"));
				user.setUserpassword(rs.getString("userpassword"));
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
		return user;
	}

	public ArrayList<Product> InquireType(String type) {
		Connection conn = null;
		Statement stmt = null;
		ArrayList<Product> result = new ArrayList<Product>();
		try {
			conn = DriverManager.getConnection(jdbcurl, jdbcuser, jdbcpassword);
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
			conn = DriverManager.getConnection(jdbcurl, jdbcuser, jdbcpassword);
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT price, name , detail FROM product_table WHERE no ='" + no + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				result.add(rs.getString("name"));
				result.add(rs.getString("detail").replaceAll(" ", ""));
				result.add(rs.getString("price"));
				result.add(no.substring(0, 3) + "/" + no.substring(3, 6) + "/" + no + ".jpg");
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
		return result;
	}

	public ArrayList<Product> Inquiremultiid(String noArray[]) {
		Connection conn = null;
		Statement stmt = null;
		ArrayList<Product> result = new ArrayList<Product>();
		try {
			conn = DriverManager.getConnection(jdbcurl, jdbcuser, jdbcpassword);
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT no,price, name FROM product_table WHERE ";
			for (String no : noArray) {
				sql = sql + "no ='" + no + "' or ";
			}
			sql = sql.substring(0, sql.length() - 3);
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

	public Map<String,ShopCart> Inquireshopcart(String username) {
		Connection conn = null;
		Statement stmt = null;
		Map<String,ShopCart> result = new HashMap<>();
		try {
			conn = DriverManager.getConnection(jdbcurl, jdbcuser, jdbcpassword);
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT product_table.name , product_table.price , shop_cart.productnum , shop_cart.productno FROM shop_cart JOIN product_table ON product_table.no = shop_cart.productno where shop_cart.username ='"
					+ username + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ShopCart shopcart = new ShopCart();
				shopcart.setProductname(rs.getString("product_table.name"));
				shopcart.setProductno(rs.getString("shop_cart.productno"));
				shopcart.setProductnum(rs.getInt("shop_cart.productnum"));
				String no = rs.getString("shop_cart.productno");
				shopcart.setProductimg(no.substring(0, 3) + "/" + no.substring(3, 6) + "/" + no + ".jpg");
				shopcart.setProductprice(rs.getInt("product_table.price"));
				result.put(no, shopcart);
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
		return result;
	}
}
