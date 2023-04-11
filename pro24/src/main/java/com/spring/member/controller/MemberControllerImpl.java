package com.spring.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.spring.member.service.MemberService;
import com.spring.member.service.MemberServiceImpl;
import com.spring.member.vo.MemberVO;

public class MemberControllerImpl extends MultiActionController implements MemberController {
	
	private MemberService memberService;
	
	// setter�� memberService ���� ����
	public void setMemberService(MemberServiceImpl memberService) {
		this.memberService = memberService;
	}

	@Override
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		List membersList = memberService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);
		// ModelAndView�� addObject()�޼��带 �̿��� ��ȸ�� ȸ������ ���ε�
		mav.addObject("membersList", membersList);
		return mav;
	}
	
	//���� �߰�
	@Override
	public ModelAndView modMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		
		MemberVO memInfo = memberService.modMember(id);
		
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("memInfo", memInfo);
		return mav;
	}
	
	//����
	@Override
	public ModelAndView updateMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		MemberVO memberVO = new MemberVO();
		
		bind(request,memberVO);
		int result = 0;
		result = memberService.updateMember(memberVO);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}
	
	@Override
	public ModelAndView addMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		MemberVO memberVO = new MemberVO();
		
		//ȸ������â���� ���۵� ȸ�������� memberVO �Ӽ��� �ڵ����� ����
		bind(request,memberVO);
		int result = 0;
		result = memberService.addMember(memberVO);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do"); //ModelAndView Ŭ������ redirect �Ӽ��� �̿��� ȸ�� ���â���� �����̷�Ʈ
		return mav;
	}
	
	@Override
	public ModelAndView removeMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		memberService.removeMember(id);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}
	
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	
	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if(uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}
		
		int begin = 0;
		if(!(contextPath == null || contextPath.equals(""))) {
			begin = contextPath.length();
		}
		
		int end = 0;
		if(uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1 ) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}
		
		String fileName = uri.substring(begin,end);
		if(fileName.indexOf(".") != -1) {
			fileName = fileName.substring(0,fileName.lastIndexOf("."));
		}
		if(fileName.lastIndexOf("/") != -1) {
			fileName = fileName.substring(fileName.lastIndexOf("/"),fileName.length());
		}
		return fileName;
				
	}
}
