package com.saleforce.javadao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDaoImpl implements AuthorDao {
	
	private Connection getConnection() {
		// 0. import java.sql.*;
		Connection conn = null;
		
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "hr", "hr");
			System.out.println("접속성공");
		
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} 
		
		return conn;
	}

	@Override
	public int insert(AuthorVO vo) {
//		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
//			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻어오기
//			String url = "jdbc:oracle:thin:@localhost:1521:xe";
//			conn = DriverManager.getConnection(url, "hr", "hr");
//			System.out.println("접속성공");
			conn = getConnection();
			
			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "INSERT INTO author(author_name, author_desc, author_id) VALUES ( ?, ?, seq_author_id.nextval )";
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, vo.getAuthor_name()); //"강풀"
			pstmt.setString(2, vo.getAuthor_desc()); //"웹툰1세대"

			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(vo.toString());
			System.out.println(count + "건 처리");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 5. 자원정리
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}

		}
		return count;
	}

	@Override
	public List<AuthorVO> getList() {
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		List<AuthorVO> result = new ArrayList<>();

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
//			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻어오기
//			String url = "jdbc:oracle:thin:@localhost:1521:xe";
//			conn = DriverManager.getConnection(url, "hr", "hr");
//			System.out.println("접속성공");
			conn = getConnection();
			
			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "Select * FROM author";
			pstmt = conn.prepareStatement(query);

//			pstmt.setString(1, vo.getAuthor_name()); //"강풀"
//			pstmt.setString(2, vo.getAuthor_desc()); //"웹툰1세대"

			rs = pstmt.executeQuery();

			// 4.결과처리
			System.out.println(count + "건 처리");
			
			while(rs.next()) {
				count++;
				AuthorVO vo = new AuthorVO(rs.getInt(3), rs.getString(1), rs.getString(2));
				result.add(vo);
			}
			System.out.println(result);

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 5. 자원정리
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}

		}
		return result;
	}

	@Override
	public int delete(int authorId) {

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
//			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻어오기
//			String url = "jdbc:oracle:thin:@localhost:1521:xe";
//			conn = DriverManager.getConnection(url, "hr", "hr");
//			System.out.println("접속성공");
			conn = getConnection();
			
			// 3. SQL문 준비 / 바인딩 / 실행
			String query = ""; 
			query = " DELETE FROM author a WHERE a.author_id = ?   ";
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, authorId); 

			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(authorId);
			System.out.println(count + "건 처리");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 5. 자원정리
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}

		}
		return count;

	}

	@Override
	public int update(AuthorVO vo) {

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
//			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻어오기
//			String url = "jdbc:oracle:thin:@localhost:1521:xe";
//			conn = DriverManager.getConnection(url, "hr", "hr");
//			System.out.println("접속성공");
			conn = getConnection();
			
			// 3. SQL문 준비 / 바인딩 / 실행
			String query = ""; 
			query =   " UPDATE author a     \n" + 
					" SET a.author_desc = ? \n" + 
					" WHERE a.author_id = ?   ";
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, vo.getAuthor_desc()); //"강풀"
			pstmt.setInt(2, vo.getAuthor_id()); //"웹툰1세대"

			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(vo.toString());
			System.out.println(count + "건 처리");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 5. 자원정리
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}

		}
		return count;
	}

}
