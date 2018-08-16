package com.amazon.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amazon.bin.News;
import com.amazon.bin.Product;
import com.amazon.biz.ProductBiz;
import com.amazon.bizimpl.ProductBizImpl;

@WebServlet("/doindex")
public class IndexServlet extends HttpServlet {
	ProductBiz IProductBiz = new ProductBizImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		List<Product> list = IProductBiz.productSort();
		List<Product> plist = IProductBiz.queryAllProduct();
		List<News> nlist = IProductBiz.getNews();
		
		req.setAttribute("producttype", list);
		req.setAttribute("allproduct", plist);
		req.setAttribute("newslist", nlist);
		List<Product> p = new ArrayList<>();
		// 读取cookie
		Cookie[] cookies = req.getCookies();
		if (cookies == null) {

		} else {
			
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("histroyrecord")) {
					String value = cookie.getValue();// 得到拼接好的字符串
					String[] ids = value.split("-");
					for (String id : ids) {
						System.out.println(id);
						Product product = IProductBiz.getProductById(id);
						p.add(product);
						System.out.println("size:"+p.size());
					}
				}

			}
			
		}
		req.getSession().setAttribute("productlist", p);
		System.out.println(p.get(0).getFileName());
		req.getRequestDispatcher("/index.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
