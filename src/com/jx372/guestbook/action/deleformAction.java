package com.jx372.guestbook.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jx372.web.action.Action;
import com.jx372.web.util.WebUtils;

public class deleformAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		WebUtils.forward("./WEB-INF/views/deleteform.jsp", request, response);
	}

}
