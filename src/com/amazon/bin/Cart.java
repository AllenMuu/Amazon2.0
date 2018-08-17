package com.amazon.bin;

public class Cart {
	private int cartId;
	private int productcount;
	private int productid;
	private int userid;
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getProductcount() {
		return productcount;
	}
	public void setProductcount(int productcount) {
		this.productcount = productcount;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public Cart(int productcount, int productid, int userid) {
		super();
		
		this.productcount = productcount;
		this.productid = productid;
		this.userid = userid;
	}
	
	public Cart() {
		super();
	}
	
	
	
	
}
