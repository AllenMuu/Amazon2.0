package com.amazon.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amazon.bin.News;
import com.amazon.biz.ProductBiz;
import com.amazon.bizimpl.ProductBizImpl;

@WebServlet("/readnews")
public class NewsServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductBiz IProductBiz = new ProductBizImpl();
		req.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(req.getParameter("newsId"));
		News news = IProductBiz.getNewsById(id);
		req.setAttribute("newsinfo", news);
		req.getRequestDispatcher("/news_view.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
