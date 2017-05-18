package com.jx372.guestbook.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jx372.guestbook.Dao.GuestBookDao;
import com.jx372.guestbook.vo.GuestBookVo;
import com.jx372.web.action.Action;

public class deleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String pass=request.getParameter("pass");
		String no=request.getParameter("no");
		System.out.println(no + " : "+ pass);
		Long No = Long.parseLong(no);
		GuestBookVo vo = new GuestBookVo();
		vo.setPasswd(pass);
		vo.setNo(No);
		new GuestBookDao().delete(vo);
		//리다이렉트 응답
		response.sendRedirect("./gb");
	}

}
