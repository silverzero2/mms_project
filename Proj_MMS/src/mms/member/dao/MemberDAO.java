package mms.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mms.member.db.JbdcUtil;
import mms.member.vo.Member;

public class MemberDAO {
	Connection con;
	PreparedStatement pstmt;
	
	// DB연결
	public MemberDAO(Connection con) {
		// con에 getConnection 메소드 저장
		con = JbdcUtil.getConnection();
		this.con = con;
	}
	
	// insert
	public int insertNewMember(Member newMember) { // 테이블명은 본인이 create한 걸로 체크
		String sql = "insert into mms_member(id, name, addr, nation, email, age) values(member_id_seq.nextval,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newMember.getName());
			pstmt.setString(2, newMember.getAddr());
			pstmt.setString(3, newMember.getNation());
			pstmt.setString(4, newMember.getEmail());
			pstmt.setInt(5, newMember.getAge());
			pstmt.executeUpdate();
			JbdcUtil.close1(pstmt);
			JbdcUtil.commit(con);
		} catch (SQLException e) {
			e.printStackTrace();
			JbdcUtil.rollback(con);
		} JbdcUtil.close(con);
		return 0;
	}
	
	// 전체 select
	public ArrayList<Member> selectMemberList() {
		
		ArrayList<Member> m= new ArrayList<Member>();
		ResultSet rs = null;
		String sql = "select * from mms_member";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				m.add(new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
			}
			JbdcUtil.close1(pstmt);
			JbdcUtil.close2(rs);
			//JbdcUtil.commit(con);
		} catch (SQLException e) {
			e.printStackTrace();
			//JbdcUtil.rollback(con);
		}
		return m;
	}
	
	// oldmember select
	public Member selectOldMember(String name) {
		ResultSet rs = null;
		Member m = null;
		String sql = "select * from mms_member where name=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				m = new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
			} JbdcUtil.close1(pstmt);
			JbdcUtil.close2(rs);
			//JbdcUtil.commit(con);
		} catch (SQLException e) {
			e.printStackTrace();
			//JbdcUtil.rollback(con);
		}
		return m;
	}
	
	// update
	public int updateMember(Member updateMember) {
		String sql = "update mms_member set addr=?, nation=?, email=?, age=? where name=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, updateMember.getAddr());
			pstmt.setString(2, updateMember.getNation());
			pstmt.setString(3, updateMember.getEmail());
			pstmt.setInt(4, updateMember.getAge());
			pstmt.setString(5, updateMember.getName());
			pstmt.executeUpdate();
			JbdcUtil.close1(pstmt);
			JbdcUtil.commit(con);
		} catch (SQLException e) {
			e.printStackTrace();
			JbdcUtil.rollback(con);
		} JbdcUtil.close(con);
		return 0;
	}
	
	// delete
	public int deleteMember(String name) {
		String sql = "delete mms_member where name=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
			JbdcUtil.close1(pstmt);
			JbdcUtil.commit(con);
		} catch (SQLException e) {
			e.printStackTrace();
			JbdcUtil.rollback(con);
		} JbdcUtil.close(con);
		return 0;
	}
}
