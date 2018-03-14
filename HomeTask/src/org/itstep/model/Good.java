package org.itstep.model;

public class Good {
	private String asin;
	private String name;
	private Integer price;
	private Integer initial_price; 
	private String img_url; 
	private String good_url;
	
	public String getAsin() {
		return asin;
	}
	public void setAsin(String asin) {
		this.asin = asin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getInitialPrice() {
		return initial_price;
	}
	public void setInitialPrice(Integer initial_price) {
		this.initial_price = initial_price;
	}
	public String getImgUrl() {
		return img_url;
	}
	public void setImgUrl(String img_url) {
		this.img_url = img_url;
	}
	public String getGoodUrl() {
		return good_url;
	}
	public void setGoodUrl(String good_url) {
		this.good_url = good_url;
	}
	
}

