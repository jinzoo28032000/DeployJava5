package com.example.ass.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.example.ass.entities.Order;
import com.example.ass.util.CartUtil;

@Component
public class CartInterceptor implements HandlerInterceptor {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		Order order = CartUtil.getCartInSession(request);
		if (modelAndView == null) {
			return;
		}
		modelAndView.getModelMap().addAttribute("quantity", order.getQuantity());
		modelAndView.getModelMap().addAttribute("cart", order);
	}
}
