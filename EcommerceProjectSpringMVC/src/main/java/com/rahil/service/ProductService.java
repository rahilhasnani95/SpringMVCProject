package com.rahil.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rahil.dao.ProductDAO;
import com.rahil.entities.ProductBean;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productdao;

	public List<ProductBean> getprod()
	{
		return productdao.getProducts();
	}
	
	public List<ProductBean> getAllprodforadmin()
	{
		return productdao.getAllProductsforAdmin();
	}
	
	public void updateQuantityofProducts(int itemid, int quantity)
	{
		productdao.updateQuantityOfProductAdmin(itemid, quantity);
	}

	public void addNewProduct(String itemname, int itemprice, int itemquantity)
	{
		productdao.addNewProductAdmin(itemname, itemprice, itemquantity);
	}
	
}
