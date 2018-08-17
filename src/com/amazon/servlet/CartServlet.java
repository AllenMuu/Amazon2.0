package com.amazon.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amazon.bin.Cart;
import com.amazon.bin.User;
import com.amazon.biz.ProductBiz;
import com.amazon.bizimpl.ProductBizImpl;

@WebServlet("/doaddcart")
public class CartServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductBiz IProductBiz = new ProductBizImpl();
		User user = (User) req.getSession().getAttribute("user");
		int userid = user.getUserId();
		System.out.println("userid="+userid);
		int productid = Integer.parseInt(req.getParameter("productid"));
		int productcount = Integer.parseInt(req.getParameter("productcount"));
		//封装成Cart对象
		Cart cart = new Cart(productcount, productid, userid);
		int res = IProductBiz.addCart(cart);
		List<Cart> cartlist = IProductBiz.queryCart(userid);
		if (res > 0) {
//			req.getSession().setAttribute("shoppingList", cartlist);
//			req.getRequestDispatcher("/GoToOrderJspServlet").forward(req, resp);
			System.out.println("user"+user+"cart"+cart);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
