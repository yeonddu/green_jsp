package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ThirdServlet
 */
@WebServlet("/third")
public class ThirdServlet extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		// ó�� ���۵Ǹ� init ����. ���� ȯ�漳���� �޾� ���� ����
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// ������ �÷��ǿ��� 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// init ��ü������ �� ����,,�Ű������� request, response ��� �ޱ�
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
