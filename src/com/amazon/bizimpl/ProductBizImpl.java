package com.amazon.bizimpl;

import java.sql.SQLException;
import java.util.List;

import com.amazon.bin.Cart;
import com.amazon.bin.News;
import com.amazon.bin.Product;
import com.amazon.biz.ProductBiz;
import com.amazon.dao.ProductDao;
import com.amazon.daoimpl.ProductDaoImpl;
import com.amazon.utils.C3P0Util;


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

	@Override
	public List<Product> productSortById(String categoryid) {
		List<Product> list = null;
		try {
			list = IProductDao.getProductTypeById(categoryid);
		} catch (SQLException e) {
			throw new RuntimeException("商品标题种类失败");
		}
		return list;
	}
	
	
	@Override
	public int addCart(Cart cart) {
		int res = 0;
		try {
			C3P0Util.startTransaction();
			res = IProductDao.save(cart);
			C3P0Util.commit();
		} catch (SQLException e) {
			try {
				C3P0Util.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException("加入购物车 failure");
		}
		return res;
	}
	
	
	@Override
	public List<Cart> queryCart(int userid) {
		List<Cart> list = null;
		try {
			list = IProductDao.queryCartById(userid);
		} catch (SQLException e) {
			throw new RuntimeException("查询购物车信息失败");
		}
		return list;
	}

}
