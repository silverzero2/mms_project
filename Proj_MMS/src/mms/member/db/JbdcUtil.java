package mms.member.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JbdcUtil {
	// 클래스가 로딩될 때 단 한번 호출되는 영역
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// DB 작업에 필요한 Connection 객체를 생성해주는 메소드
	public static Connection getConnection() {
		Connection con=null;
		try {
			String sql = "jdbc:oracle:thin:@localhost:1521:orcl";
		
			con = DriverManager.getConnection(sql, "javalink", "javalink"); // javalink에 연결
			con.setAutoCommit(false);
		} catch (SQLException e) {
			
		} return con;	
	}
	
	public static void close(Connection con) {
		try {
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close1(PreparedStatement pstmt) {
		try {
			pstmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close2(ResultSet rs) {
		try {
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	// transaction 처리 메소드
	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
