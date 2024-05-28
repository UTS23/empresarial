package com.papeleria.app.service;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpSession;

public class UserServiceImpl implements UserService{

	@Override
	public void removeSessionMessage() {
		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest()
				.getSession();
		
		session.removeAttribute("msg");
		
	}

}
