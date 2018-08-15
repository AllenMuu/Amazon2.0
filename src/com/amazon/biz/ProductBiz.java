package com.amazon.biz;

import java.util.List;

import com.amazon.bin.News;
import com.amazon.bin.Product;

public interface ProductBiz {
	public List<Product> productSort();

	public List<News> getNews();
	
	public News getNewsById(int newsId);

	public List<Product> queryAllProduct();

	public Product getProductById(int id);
}
