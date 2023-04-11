package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ThirdServlet
 */
@WebServlet("/third_9_1_2")
public class ThirdServlet extends HttpServlet {

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_address = request.getParameter("user_address");
		
		out.println("����° �����Դϴ�.<br>");
		out.println("<html><body>");
		if(user_id!=null && user_id.length()!=0) {
			out.println("�̹� �α��� �����Դϴ�!<br><br>");
			out.println("�� ��° ��������  �Ѱ��� ���̵�: " + user_id + "<br>");
			out.println("�� ��° ��������  �Ѱ��� ��й�ȣ: " + user_pw + "<br>");
			out.println("�� ��° ��������  �Ѱ��� �ּ�: " + user_address + "<br>");
			out.println("</body></html>");
		} else {
			out.println("�α��� ���� �ʾҽ��ϴ�<br><br>");
			out.println("�ٽ� �α����ϼ���!!<br>");
			out.println("<a href='/pro09/login2.html'>�α���â���� �̵��ϱ�</a>");
		}
	}

}
