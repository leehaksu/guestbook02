package com.jx372.guestbook.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jx372.guestbook.Dao.GuestBookDao;
import com.jx372.guestbook.vo.GuestBookVo;
import com.jx372.web.action.Action;

public class addAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		String name =request.getParameter("name");
		String pass=request.getParameter("pass");
		String message=request.getParameter("message");
		System.out.println("name : " + name +"pass : " + pass + "message : " + message);
		GuestBookVo vo = new GuestBookVo();
		vo.setName(name);
		vo.setPasswd(pass);
		vo.setMessage(message);
		new GuestBookDao().insert(vo);
		//리다이렉트 응답
		response.sendRedirect("./gb");

	}

}
