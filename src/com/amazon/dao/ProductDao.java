package com.amazon.dao;

import java.sql.SQLException;
import java.util.List;

import com.amazon.bin.News;
import com.amazon.bin.Product;

public interface ProductDao {
	public List<Product> getProductType() throws SQLException;
	
	public List<News> getAllNews() throws SQLException;
	
	public News getNewsById(int newsId) throws SQLException;

	public List<Product> getAllProducts() throws SQLException;
	
	public Product getProductinfoById(String id) throws SQLException;

	public List<Product> getProductTypeById(String categoryid) throws SQLException;
}
