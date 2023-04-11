package test;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/boad/*")
public class StudentController extends HttpServlet {

	StudentDAO studentDAO;
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출");
		studentDAO = new StudentDAO();
	}

	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo();
		System.out.println("action" + action);
		
		if(action==null || action.equals("/studentlists.do")) {
			List<StudentVO> studentsList = studentDAO.listStudent();
			request.setAttribute("studentsList", studentsList);
			nextPage = "/test03/listStudents.jsp";
			
		} else if (action.equals("/addStudent.do")) {
			
			String userName = request.getParameter("userName");
			String univ = request.getParameter("univ");
			String birth = request.getParameter("birth");
			String email = request.getParameter("email");
			StudentVO studentVo = new StudentVO(userName, univ, birth, email);
			studentDAO.addStudent(studentVo);
			nextPage = "/boad/studentlists.do";
						
		} else if(action.equals("/studentForm.do")) {
			nextPage = "/test03/studentForm.jsp";
			
		} else {
			
			nextPage = "/test03/listStudents.jsp";
		}
		
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}
}
