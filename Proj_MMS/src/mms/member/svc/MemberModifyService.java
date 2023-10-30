package mms.member.svc;

import java.sql.Connection;

import mms.member.dao.MemberDAO;
import mms.member.vo.Member;

public class MemberModifyService {
	Connection con;
	
	MemberDAO dao = new MemberDAO(con);
	
	public Member getOldMember(String name) {
		return dao.selectOldMember(name);
	}
	
	public boolean ModifyMember(Member updateMember) {
		boolean result;
		
		if(dao.updateMember(updateMember) == 0) {
			result = true;
		} else {
			result = false;
		}
		
		return result;
	}
}
