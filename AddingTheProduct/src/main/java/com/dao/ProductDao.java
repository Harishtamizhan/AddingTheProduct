package com.dao;
import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.Product;

public class ProductDao {
	public int storeProduct(Product product) {
		try {
			Configuration con =new Configuration();
			con.configure("hibernate.cfg.xml");     //load the xml file
			SessionFactory sf = con.buildSessionFactory();   //connection con
			Session session = sf.openSession();        //statement or preparedstatement
			Transaction tran = session.getTransaction();
			tran.begin();
			session.save(product);                       //insert query
			tran.commit();
			return 1;
			}
			catch(Exception e){
				System.out.println(e);
				return 0;
				
			}
		}
	 public List<Product> findAllProduct(){
		 Configuration con =new Configuration();
			con.configure("hibernate.cfg.xml");     //load the xml file
			SessionFactory sf = con.buildSessionFactory();   //connection con
			Session session = sf.openSession();  
			TypedQuery qry = session.createQuery("select p from Product p");
			List<Product> listOfProduct = qry.getResultList();
			return listOfProduct;
			
	 }
	

}
