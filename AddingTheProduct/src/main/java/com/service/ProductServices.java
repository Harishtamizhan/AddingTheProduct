package com.service;

import java.util.Iterator;
import java.util.List;

import com.bean.Product;
import com.dao.ProductDao;

public class ProductServices {
	
ProductDao pd = new ProductDao();
	
	public String storeProduct(Product product) {
		/*if(product.getPrice()<100) {
			return "Product price must be > 100";
		}else */
		if(pd.storeProduct(product)>0) {
			return "Product stored successfully";
		}else {
			return "Product didn't store id must be unique";
		}
	}
	public List<Product> findAllProduct(){
		List<Product> listOfProduct = pd.findAllProduct();
		Iterator<Product> li = listOfProduct.iterator();
		while(li.hasNext()) {
			Product p = li.next();
			p.setPrice(p.getPrice());
		}
		return listOfProduct;
		
	}


}
