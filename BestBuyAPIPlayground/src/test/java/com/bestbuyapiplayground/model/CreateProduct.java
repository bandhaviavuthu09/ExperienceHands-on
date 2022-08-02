package com.bestbuyapiplayground.model;


public class CreateProduct {
		
		private String name;
		private String type;
		private Integer price;
		private int shipping;
		private String upc;
		private String description;
		private String manufacturer;
		public void setPrice(Integer price) {
			this.price = price;
		}
		public void setShipping(int shipping) {
			this.shipping = shipping;
		}
		private String model;
		private String url;
		private String image;

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		
		
		
		public String getUpc() {
			return upc;
		}
		
		
		public void setUpc(String upc) {
			this.upc = upc;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getManufacturer() {
			return manufacturer;
		}
		public Integer getPrice() {
			return price;
		}
		public int getShipping() {
			return shipping;
		}
		public void setManufacturer(String manufacturer) {
			this.manufacturer = manufacturer;
		}
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		
		
		
	}
