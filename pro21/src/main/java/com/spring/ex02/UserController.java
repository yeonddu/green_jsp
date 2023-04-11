package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

//���� ������ userMethodNameResolver ������Ƽ�� ����ϱ� ���� �ݵ�� MultiActionController ���
public class UserController extends MultiActionController {
	
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String userID = "";
		String passwd = "";
		//getViewName() �޼��带 ȣ���Ͽ� ��û���� Ȯ���.do�� ������ ���̸��� �����´�.
		String viewName = getViewName(request);
		
		ModelAndView mav = new ModelAndView();
		request.setCharacterEncoding("utf-8");
		userID = request.getParameter("userID");
		passwd = request.getParameter("passwd");

		//ModelAndView�� �α��� ���� ���ε�
		mav.addObject("userID",userID);
		mav.addObject("passwd",passwd);
		//ModelAndView ��ü�� ���̸� ����
		mav.setViewName(viewName);
		System.out.println("ViewName: " + viewName);
		return mav;
	}
	
	//request ��ü���� URL ��û���� ������ .do�� ������ ��û���� ���Ѵ�.
	private String getViewName (HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if(uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}
		
		int begin = 0;
		if(!((contextPath==null) || ("".equals(contextPath)))) {
			begin = contextPath.length(); //http���� ������Ʈ�����
		}
		
		int end;
		if(uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length(); // test/login.do
		}
		
		String fileName = uri.substring(begin, end);
		if(fileName.indexOf(".") != -1) {
			fileName = fileName.substring(0,fileName.lastIndexOf(".")); // test/login
		}
		if(fileName.lastIndexOf("/") != -1) {
			fileName = fileName.substring(fileName.lastIndexOf("/"), fileName.length()); // login
		}
		return fileName;
	}
}
