package com.amazon.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amazon.bin.Product;
import com.amazon.biz.ProductBiz;
import com.amazon.bizimpl.ProductBizImpl;
import com.amazon.utils.LinkIdUtil;

@WebServlet("/doproduct")
public class ProductRecordServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductBiz IProductBiz = new ProductBizImpl();
		String param = req.getParameter("param");
		
			String id = req.getParameter("productId");
			LinkIdUtil link = new LinkIdUtil();
			String linkid = link.linkID(id, req);
			Cookie cookie = new Cookie("histroyrecord", linkid);
			cookie.setPath(req.getContextPath());
			cookie.setMaxAge(Integer.MAX_VALUE);
			resp.addCookie(cookie);// 把cookie存到客户端
			Product product = IProductBiz.getProductById(id);
			req.setAttribute("product", product);
			req.getRequestDispatcher("/product_view.jsp").forward(req, resp);
		
		
		
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
