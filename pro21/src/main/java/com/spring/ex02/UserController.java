package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

//설정 파일의 userMethodNameResolver 프로퍼티를 사용하기 위해 반드시 MultiActionController 상속
public class UserController extends MultiActionController {
	
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String userID = "";
		String passwd = "";
		//getViewName() 메서드를 호출하여 요청명에서 확장명.do를 제외한 뷰이름을 가져온다.
		String viewName = getViewName(request);
		
		ModelAndView mav = new ModelAndView();
		request.setCharacterEncoding("utf-8");
		userID = request.getParameter("userID");
		passwd = request.getParameter("passwd");

		//ModelAndView에 로그인 정보 바인딩
		mav.addObject("userID",userID);
		mav.addObject("passwd",passwd);
		//ModelAndView 객체에 뷰이름 설정
		mav.setViewName(viewName);
		System.out.println("ViewName: " + viewName);
		return mav;
	}
	
	//request 객체에서 URL 요청명을 가져와 .do를 제외한 요청명을 구한다.
	private String getViewName (HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if(uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}
		
		int begin = 0;
		if(!((contextPath==null) || ("".equals(contextPath)))) {
			begin = contextPath.length(); //http에서 프로젝트명까지
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
