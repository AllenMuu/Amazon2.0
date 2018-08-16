package com.amazon.bizimpl;

import java.sql.SQLException;
import java.util.List;

import com.amazon.bin.News;
import com.amazon.bin.Product;
import com.amazon.biz.ProductBiz;
import com.amazon.dao.ProductDao;
import com.amazon.daoimpl.ProductDaoImpl;

public class ProductBizImpl implements ProductBiz{
	
		private ProductDao IProductDao = null;

		public ProductBizImpl() {
			IProductDao = new ProductDaoImpl();
		}

	@Override
	public List<Product> productSort() {
		List<Product> list = null;
		try {
			list = IProductDao.getProductType();
		} catch (SQLException e) {
			throw new RuntimeException("查询商品种类失败");
		}
		return list;
	}

	@Override
	public List<News> getNews() {
		List<News> list = null;
		try {
			list = IProductDao.getAllNews();
		} catch (SQLException e) {
			throw new RuntimeException("得到新闻失败");
		}
		return list;
	}

	@Override
	public News getNewsById(int newsId) {
		News news = null;
		try {
			news  = IProductDao.getNewsById(newsId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return news;
	}

	@Override
	public List<Product> queryAllProduct() {
		List<Product> list = null;
		try {
			list = IProductDao.getAllProducts();
		} catch (SQLException e) {
			throw new RuntimeException("得到商品失败");
		}
		return list;
	}

	@Override
	public Product getProductById(String id) {
		Product Product = null;
		try {
			Product  = IProductDao.getProductinfoById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Product;
	}

}
