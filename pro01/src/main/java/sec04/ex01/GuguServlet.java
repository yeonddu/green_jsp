package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuguServlet
 */
@WebServlet("/gugu")
public class GuguServlet extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String gugu_num = request.getParameter("gugu_num");
		int num = Integer.parseInt(gugu_num);
		
		out.print("<html>");
		out.print("<body>");
		out.print("<table border='1px solid gray'>");
		out.print("<tr>");
		out.print("<th colspan=2 align=center bgcolor=pink>"+num+"단 출력</th>");
		out.print("</tr>");
		for(int i=1; i<=9;i++) {
		out.print("<tr>");
		out.print("<td width=100px align=center>"+num+"*"+i+"</td>");
		out.print("<td width=100px align=center>"+num*i+"</td>");
		out.print("</tr>");
		}
		out.print("</table>");
		out.print("<a href='http://localhost:8080/pro01/gugu.html'>처음으로 이동</a>");
		out.print("</body>");
		out.print("</html>");		
		
	}

}
