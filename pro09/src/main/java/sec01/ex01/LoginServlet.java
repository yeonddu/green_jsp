package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login_9_1_1")
public class LoginServlet extends HttpServlet {
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init �޼��� ȣ��");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy �޼��� ȣ��");
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
		data += "<br>";
		data += "���̵�: " + user_id;
		data += "<br>";
		data += "�н�����: " + user_pw;
		data += "<br>";
		data += "�ּ�: " + user_address;
		data += "<br>";
		data += "email: " + user_email;
		data += "<br>";
		data += "�޴���ȭ: " + user_hp;
		data += "</body></html>";
		out.print(data);
	}

}
