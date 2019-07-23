package com.rahil.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class ProductBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemid;
	private String itemname;
	private int itemprice;
	private int itemquantity;
	private java.sql.Blob itemimage;
	
	public ProductBean() {
		super();
	}
	
	public ProductBean(String itemname, int itemprice, int itemquantity) {
		this.itemname = itemname;
		this.itemprice = itemprice;
		this.itemquantity = itemquantity;
	}

	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public int getItemprice() {
		return itemprice;
	}
	public void setItemprice(int itemprice) {
		this.itemprice = itemprice;
	}
	public int getItemquantity() {
		return itemquantity;
	}
	public void setItemquantity(int itemquantity) {
		this.itemquantity = itemquantity;
	}
	public java.sql.Blob getItemimage() {
		return itemimage;
	}
	public void setItemimage(java.sql.Blob itemimage) {
		this.itemimage = itemimage;
	}
	@Override
	public String toString() {
		return "ProductBean [itemid=" + itemid + ", itemname=" + itemname + ", itemprice=" + itemprice
				+ ", itemquantity=" + itemquantity + ", itemimage=" + itemimage + "]";
	}
	

	
}
