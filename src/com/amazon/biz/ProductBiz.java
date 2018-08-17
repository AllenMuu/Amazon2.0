package com.amazon.biz;

import java.util.List;

import com.amazon.bin.Cart;
import com.amazon.bin.News;
import com.amazon.bin.Product;

public interface ProductBiz {
	public List<Product> productSort();

	public List<News> getNews();
	
	public News getNewsById(int newsId);

	public List<Product> queryAllProduct();

	public Product getProductById(String id);

	public List<Product> productSortById(String categoryid);

	public int addCart(Cart cart);

	public List<Cart> queryCart(int userid);
}
