package com.example.ass.util;

import javax.servlet.http.HttpServletRequest;

import com.example.ass.entities.Order;

public class CartUtil {
	public static Order getCartInSession(HttpServletRequest request) {

		Order order = (Order) request.getSession().getAttribute("myCart");

		if (order == null) {
			order = new Order();

			request.getSession().setAttribute("myCart", order);
		}
		return order;
	}

	public static void removeCartInSession(HttpServletRequest request) {
		request.getSession().removeAttribute("myCart");
	}

	public static void storeLastOrderedCartInSession(HttpServletRequest request, Order cartInfo) {
		request.getSession().setAttribute("lastOrderedCart", cartInfo);
	}

	public static Order getLastOrderedCartInSession(HttpServletRequest request) {
		return (Order) request.getSession().getAttribute("lastOrderedCart");
	}
}
