package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet2
 */
@WebServlet("/login_9_1_2")
public class LoginServlet2 extends HttpServlet {
	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_address = request.getParameter("user_address");
		String user_email = request.getParameter("user_email");
		String user_hp = request.getParameter("user_hp");
		
		String data = "<html><body>";
		data += "�ȳ��ϼ���! �α����ϼ̽��ϴ�.";
		data += "<br><br>";
		data += "���̵�: " + user_id;
		data += "<br>";
		data += "�н�����: " + user_pw;
		data += "<br>";
		data += "�ּ�: " + user_address;
		data += "<br>";
		data += "email: " + user_email;
		data += "<br>";
		data += "�޴���ȭ: " + user_hp;
		data += "<br>";
		
		user_address=URLEncoder.encode(user_address,"utf-8");
		data += "</body></html>";
		out.print(data);
		out.print("<a href='second_9_1_2?user_id="+user_id+"&user_pw="+user_pw+"&user_address="+user_address+"'>�ι�° �������� ������</a>");
		
	}

}
