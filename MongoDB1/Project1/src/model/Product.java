package model;

public class Product {
	private int id;
	private String description;
	private String name;
	private float price;
	private String a;
	private String konum;
	private String picture;
	public Product(int id, String name, String description, float price, String a, String konum, String picture){
		this.description = description;
		this.id = id;
		this.a = a;
		this.price = price;
		this.name = name;
		this.konum=konum;
		this.picture=picture;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getKonum() {
		return konum;
	}
	public void setKonum(String konum) {
		this.konum = konum;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
}
