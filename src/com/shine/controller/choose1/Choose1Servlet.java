package com.shine.controller.choose1;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class Choose1Servlet extends HttpServlet{
	public void service(HttpServletRequest request,
			HttpServletResponse response)throws ServletException,IOException{
			HttpSession session = request.getSession();
			request.getRequestDispatcher("findAll.you").forward(request, response);
			return;
	}

}
