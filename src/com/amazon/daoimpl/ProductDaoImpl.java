package com.amazon.daoimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.amazon.bin.Cart;
import com.amazon.bin.News;
import com.amazon.bin.Product;
import com.amazon.dao.ProductDao;
import com.amazon.utils.C3P0Util;

public class ProductDaoImpl implements ProductDao{
	/*
	 * (商品分类)
	 * @see com.amazon.dao.ProductDao#getProductType()
	 */
	@Override
	public List<Product> getProductType() throws SQLException {
		Connection conn = C3P0Util.getCurrConnection();
		String sql = "SELECT HPC_ID as categoryId,HPC_NAME as categoryName,HPC_PARENT_ID as parentTypeId FROM HWUA_PRODUCT_CATEGORY";
		Object[] params = null;
		QueryRunner qr = new QueryRunner();
		List<Product> list = qr.query(conn, sql, new BeanListHandler<>(Product.class), params);
		return list;
		
	}
	
	/*
	 * (查询所有新闻)
	 * @see com.amazon.dao.ProductDao#getAllNews()
	 */
	@Override
	public List<News> getAllNews() throws SQLException {
		Connection conn = C3P0Util.getCurrConnection();
		String sql = "SELECT HN_ID as newsId,HN_TITLE as newsTitle ,HN_CONTENT as newsContent,HN_CREATE_TIME as newsCreateTime FROM HWUA_NEWS";
		Object[] params = null;
		QueryRunner qr = new QueryRunner();
		List<News> list = qr.query(conn, sql, new BeanListHandler<>(News.class), params);
		return list;
	}
	
	/*
	 * (根据ID得到新闻)
	 * @see com.amazon.dao.ProductDao#getNewsById(int)
	 */
	@Override
	public News getNewsById(int newsId) throws SQLException {
		Connection conn = C3P0Util.getCurrConnection();
		String sql = "SELECT HN_ID as newsId,HN_TITLE as newsTitle ,HN_CONTENT as newsContent,HN_CREATE_TIME as newsCreateTime FROM HWUA_NEWS where HN_ID = ? ";
		Object[] params = {newsId};
		QueryRunner qr = new QueryRunner();
		News news = qr.query(conn, sql, new BeanHandler<>(News.class), params);
		return news;
	}

	@Override
	public List<Product> getAllProducts() throws SQLException {
		Connection conn = C3P0Util.getCurrConnection();
		String sql = "SELECT HP_ID as productId,HP_NAME as productName ,HP_DESCRIPTION as productDesp,HP_PRICE as productPrice,HP_STOCK as productStock,HPC_ID as categoryId,HPC_CHILD_ID as childTypeId,HP_FILE_NAME as fileName FROM HWUA_PRODUCT";
		Object[] params = null;
		QueryRunner qr = new QueryRunner();
		List<Product> list = qr.query(conn, sql, new BeanListHandler<>(Product.class), params);
		return list;
	}
	
	/*
	 * (根据id得到商品信息,用于存储cookie)
	 * @see com.amazon.dao.ProductDao#getProductinfoById(java.lang.String)
	 */
	@Override
	public Product getProductinfoById(String id) throws SQLException {
		Connection conn = C3P0Util.getCurrConnection();
		String sql = "SELECT HP_ID as productId,HP_NAME as productName ,HP_DESCRIPTION as productDesp,HP_PRICE as productPrice,HP_STOCK as productStock,HPC_ID as categoryId,HPC_CHILD_ID as childTypeId,HP_FILE_NAME as fileName FROM HWUA_PRODUCT where HP_ID = ? ";
		Object[] params = {id};
		QueryRunner qr = new QueryRunner();
		Product product = qr.query(conn, sql, new BeanHandler<>(Product.class), params);
		return product;
	}
	
	/*
	 * (根据id的查询大小标题,查询商品信息)
	 * @see com.amazon.dao.ProductDao#getProductTypeById(java.lang.String)
	 */
	@Override
	public List<Product> getProductTypeById(String categoryid) throws SQLException {
		Connection conn = C3P0Util.getCurrConnection();
		String sql = "SELECT HP_ID as productId,HP_NAME as productName ,HP_DESCRIPTION as productDesp,HP_PRICE as productPrice,HP_STOCK as productStock,HPC_ID as categoryId,HPC_CHILD_ID as childTypeId,HP_FILE_NAME as fileName FROM HWUA_PRODUCT where HPC_CHILD_ID = ? ";
		Object[] params = {categoryid};
		QueryRunner qr = new QueryRunner();
		List<Product> list = qr.query(conn, sql, new BeanListHandler<>(Product.class), params);
		return list;
	}
	
	/*
	 * (加入购物车)
	 * @see com.amazon.dao.ProductDao#save(com.amazon.bin.Cart)
	 */
	@Override
	public int save(Cart cart) throws SQLException {
		String sql = "insert into HWUA_CART values(null,?,?,?)";
		Connection conn=C3P0Util.getCurrConnection();
		Object[] params = { cart.getProductid(), cart.getProductcount(),cart.getUserid() };
		QueryRunner qr = new QueryRunner();
		return qr.update(conn,sql, params);
	}
	
	/*
	 * (查询购物车)
	 * @see com.amazon.dao.ProductDao#queryCartById(int)
	 */
	@Override
	public List<Cart> queryCartById(int userid) throws SQLException {
		Connection conn = C3P0Util.getCurrConnection();
		String sql = "SELECT HP_ID as productId,HP_NAME as productName ,HP_DESCRIPTION as productDesp,HP_PRICE as productPrice,HP_STOCK as productStock,HPC_ID as categoryId,HPC_CHILD_ID as childTypeId,HP_FILE_NAME as fileName FROM HWUA_PRODUCT where HPC_CHILD_ID = ? ";
		Object[] params = {userid};
		QueryRunner qr = new QueryRunner();
		List<Cart> list = qr.query(conn, sql, new BeanListHandler<>(Cart.class), params);
		return list;
	}
	
	
}
