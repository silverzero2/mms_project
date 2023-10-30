package mms.member.svc;

import java.sql.Connection;

import mms.member.dao.MemberDAO;

public class MemberRemoveService {
	Connection con;
	
	MemberDAO dao = new MemberDAO(con);
	
	public boolean removeMember(String name) {
		boolean result;
		
		if(dao.deleteMember(name) == 0) {
			result = true;
		} else {
			result = false;
		}
		
		return result;
	}
	
}
