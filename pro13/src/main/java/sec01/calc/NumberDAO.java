package sec01.calc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NumberDAO {
	
	private static final String driver = "org.mariadb.jdbc.Driver";
	private static final String url = "jdbc:mariadb://localhost:3306/servletex";
	private static final String user = "root";
	private static final String pwd = "1234";
	private Connection con;
	private PreparedStatement pstmt;
	

	public List listNumbers() {
		List list = new ArrayList();
		try {
			connDB();
			String query = "select * from c_number"; //ȸ�� ������ �ֱ� ������ ������ ��ȸ
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String num1 = rs.getString("num1");
				String op = rs.getString("op");
				String num2 = rs.getString("num2");
				int value = rs.getInt("value");
				
				NumberBean vo = new NumberBean(); //��ȸ�� ȸ�� ������ NumberBean ��ü�� �Ӽ��� ������ �� �ٽ� ArrayList�� ����
				vo.setNum1(num1);
				vo.setOp(op);
				vo.setNum2(num2);
				vo.setValue(value);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;

	}
	
	//NumberBean ��ü�� ����� ������ ���̺� ����
	public void addNumber(NumberBean numberBean) {
		try {
			connDB();
			String num1 = numberBean.getNum1();
			String op = numberBean.getOp();	
			String num2 = numberBean.getNum2();
			int value = numberBean.calc();
						
			String query = "insert into c_number"; //ȸ������ �߰�
			query += "(num1,op,num2,value)";
			query += "values(?,?,?,?)";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, num1); //values(,,,,) 1��°�� id �Է�
			pstmt.setString(2, op);
			pstmt.setString(3, num2);
			pstmt.setInt(4, value);
			
			pstmt.executeUpdate(); //query ����
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("Oracle ����̹� �ε� ����");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection ���� ����");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
