package com.shine.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mathworks.toolbox.javabuilder.MWException;

import plotTest.PlotClass;

/**
 * Servlet implementation class DrawServlet
 */
@WebServlet("/drawServlet")
public class DrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: 111").append(request.getContextPath());
	    
		try {
			PlotClass p = new PlotClass();
			p.plotTest(); 
		
			try {
				Class	clazz = Class.forName("com.mathworks.toolbox.javabuilder.internal.MWComponentInstance");
				System.out.println(clazz);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//request.getRequestDispatcher("/in.jsp").forward(request,response);
		} catch (MWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
