package gntp.model2.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Request;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import gntp.model2.dao.MemberDAO;
import gntp.model2.vo.MemberVO;

public class MemberService {
	public String sendData() {
		String jsonString = null;
		Map<String, String> obj1 = new HashMap<String, String>();
		obj1.put("name", "kim");
		obj1.put("age", "20");
		obj1.put("id", "user");
		Map<String, String> obj2 = new HashMap<String, String>();
		obj2.put("name", "lee");
		obj2.put("age", "25");
		obj2.put("id", "admin");
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		list.add(obj1);
		list.add(obj2);
		Map<String, List<Map<String, String>>> obj3 = new HashMap<String, List<Map<String,String>>>();
		obj3.put("members", list);
		jsonString = JSONObject.toJSONString(obj3);
		
		return jsonString;
	}
	
	public void testJsonObject(String json) throws ParseException {
		JSONParser parser = new JSONParser();
		JSONObject jsonObj = (JSONObject)parser.parse(json);
		JSONArray array = (JSONArray)jsonObj.get("name");
		System.out.println(jsonObj.get("name"));
		for(int i=0; i<array.size(); i++) {
			System.out.println(array.get(i));
		}
	}
	
	public boolean isMember(String id) {
		boolean flag = false;
		MemberDAO dao = new MemberDAO();
		try {
			MemberVO member = dao.selectOne(id);
			if(member!=null) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public boolean registMember(String id, String pwd, String name, String email) {
		boolean flag = false;
		MemberDAO dao = new MemberDAO();
		try {
			flag = dao.insertMember(id, pwd, name, email);
			return flag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}//registMember()
	
	public ArrayList<MemberVO> selectAll() {
		boolean flag = false;
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		MemberDAO dao = new MemberDAO();
		try {
			list = dao.selectAll();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void serviceDeleteOne(String id) throws SQLException {
		MemberDAO dao = new MemberDAO();
		dao.deleteOne(id);
	}
	
	public void updateOne(String id, String pwd, String name, String email) throws SQLException {
		MemberDAO dao = new MemberDAO();
		
		MemberVO member = new MemberVO(id, pwd, name, email, null);
		
		dao.updateOne(member);
	}
	
	public MemberVO serviceViewOne(String id) throws SQLException {
		MemberVO member = null;
		MemberDAO dao = new MemberDAO();
		member = dao.selectOne(id);
		return member;
	}
	
}
