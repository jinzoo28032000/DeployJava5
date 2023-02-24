package com.example.ass.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.example.ass.beans.AccountBean;
import com.example.ass.entities.Account;
import com.example.ass.service.AccountService;

@Component
public class AccountInterceptor implements HandlerInterceptor {

	@Autowired
	AccountService accountService;

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && modelAndView != null && !modelAndView.getModelMap().containsKey("userInfo")) {
			Account account = accountService.findByUsername(auth.getName());
			if (account != null) {
				AccountBean accountBean = new AccountBean();
				accountBean.setUsername(account.getUsername());
				accountBean.setFullname(account.getFullname());
				accountBean.setEmail(account.getEmail());
				modelAndView.getModelMap().addAttribute("userInfo", accountBean);
			}
		}
	}
}
