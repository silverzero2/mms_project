package mms.member.svc;

import java.sql.Connection;
import java.util.ArrayList;

import mms.member.dao.MemberDAO;
import mms.member.vo.Member;

public class MemberListService {
	Connection con;
	
	MemberDAO dao = new MemberDAO(con);
	
	public ArrayList<Member> getMemberList() {
		
		return dao.selectMemberList();
	}
}
