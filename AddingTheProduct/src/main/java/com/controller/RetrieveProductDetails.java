package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Product;
import com.service.ProductServices;

/**
 * Servlet implementation class RetrieveProductDetails
 */
public class RetrieveProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveProductDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		ProductServices ps=new ProductServices();
		List<Product> listOfProduct = ps.findAllProduct();
		pw.println("<h2>All product Details</h2>");
		pw.println("<table border=1>");
		
		pw.println("<tr> <th>id</th>  <th>name</th>  <th>price</th>  </tr>");
		
		Iterator<Product> li = listOfProduct.iterator();
		while(li.hasNext()) {
			Product p = li.next();
			pw.println("<tr><td>"+p.getId()+"</td><td>"+p.getName()+"</td><td>"+p.getPrice()+"</td></tr>");
		}
		
		pw.println("</table>");
		pw.println("<br/>");
		pw.println("<a href='index.html'>Main </a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
