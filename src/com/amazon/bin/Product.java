package com.amazon.bin;

public class Product {
	private int productId;
	private String categoryName;
	private String childTypeName;
	private String productName;
	private String productDesp;
	private double productPrice;
	private int productStock;
	private int categoryId;
	private int childTypeId;
	private int parentTypeId;
	private String fileName;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public String getChildTypeName() {
		return childTypeName;
	}
	public void setChildTypeName(String childTypeName) {
		this.childTypeName = childTypeName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesp() {
		return productDesp;
	}
	public void setProductDesp(String productDesp) {
		this.productDesp = productDesp;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductStock() {
		return productStock;
	}
	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public int getChildTypeId() {
		return childTypeId;
	}
	public void setChildTypeId(int childTypeId) {
		this.childTypeId = childTypeId;
	}
	public int getParentTypeId() {
		return parentTypeId;
	}
	public void setParentTypeId(int parentTypeId) {
		this.parentTypeId = parentTypeId;
	}
	public Product() {
		super();
	}
	
	
	
	
	
}
