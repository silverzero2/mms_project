package mms.member.svc;

import java.sql.Connection;

import mms.member.dao.MemberDAO;
import mms.member.vo.Member;
// 회원 정보 추가를 위한 서비스 로직
public class MemberAddService {
	Connection con;
	// MemberDAO 따라가기
	// public MemberDAO(Connection con) // insertNewMember 사용
	MemberDAO dao = new MemberDAO(con);
	
	// 리턴 타입은 boolean
	public boolean addMember(Member newMember) throws Exception{
		boolean result;
		// public int insertNewMember(Member newMember) >> 정상 실행되었다면, 리턴값이 0임
		if(dao.insertNewMember(newMember) == 0) {
			result = true;
		} else {
			result = false;
		}
		
		return result;
	}
}
