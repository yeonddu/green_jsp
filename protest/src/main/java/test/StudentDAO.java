package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class StudentDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public StudentDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/servletex");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List listStudent() {
		List studentList = new ArrayList();
		try {
			con = dataFactory.getConnection();
			String query = "select * from studentlists";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String userName = rs.getString("userName");
				String univ = rs.getString("univ");
				String birth = rs.getString("birth");
				String email = rs.getString("email");
				StudentVO studentVo = new StudentVO(id, userName, univ, birth, email);
				studentList.add(studentVo);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return studentList;
	}
	public void addStudent(StudentVO m) {
		try {
			con = dataFactory.getConnection();
			String userName = m.getUserName();
			String univ = m.getUniv();
			String birth = m.getBirth();
			String email = m.getEmail();
			String query = "INSERT INTO studentlists(userName,univ,birth,email)" + "VALUES(?,?,?,?)";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,userName);
			pstmt.setString(2,univ);
			pstmt.setString(3,birth);
			pstmt.setString(4,email);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
