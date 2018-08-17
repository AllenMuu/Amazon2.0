package com.amazon.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amazon.bin.Product;
import com.amazon.biz.ProductBiz;
import com.amazon.bizimpl.ProductBizImpl;

@WebServlet("/doshow")
public class ProductServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductBiz IProductBiz = new ProductBizImpl();
		req.setCharacterEncoding("utf-8");
		String categoryId = req.getParameter("categoryId");
		System.out.println("categoryId"+categoryId);
		List<Product> typeproduct = IProductBiz.productSortById(categoryId);
		req.setAttribute("protypeid", typeproduct);
		req.getRequestDispatcher("/product-list.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
