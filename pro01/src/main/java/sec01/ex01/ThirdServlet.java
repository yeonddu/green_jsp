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
		// 처음 시작되면 init 실행. 서블릿 환경설정을 받아 구조 생성
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// 가비지 컬렉션에서 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// init 객체생성된 후 실행,,매개변수로 request, response 모두 받기
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
