package com.salesforce.account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {
	
	public Connection getConnection() {
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
	public AccountVO getBalance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountVO> getListAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountVO> getList(String searchStartDate, String searchEndDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountVO> getList(String tradingDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertTradeInfo(String type, int amount) {

		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "INSERT INTO account(seq_id, deposit, withdraw, tr_date, balance) " +
					       "VALUES ( ACCOUNT_SEQ_ID.nextval, ?, 0, sysdate, ? )";
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, amount);
			pstmt.setInt(2, amount);
			
			count = pstmt.executeUpdate();

			// 4.결과처리
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
