package com.shine.controller.daoyou;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shine.entity.EmpDaoyou;
import com.shine.entity.Result;
import com.shine.entity.User;
import com.shine.service.daoyou.DaoyouServiceImpl;


@WebServlet("*.dao")
public class DaoyouServlet extends HttpServlet{
	protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		String url = request.getRequestURI();
		String[] strs = url.split("/");
		url = strs[strs.length-1];
		System.out.println(url);
		DaoyouServiceImpl service = new DaoyouServiceImpl();
		HttpSession session = request.getSession();
		EmpDaoyou user = (EmpDaoyou)session.getAttribute("EmpDaoyou");
		
			if("findAll.dao".equals(url)) {
				
				Result result = service.findAll();
				System.out.println("进入列表");
				request.setAttribute("empdys", result.getData());
				//需要改变的地方，jsp
				request.getRequestDispatcher("/daoyou/listdaoyou.jsp").forward(request, response);
			}
			if("e-findAll.dao".equals(url)) {
				
				Result result = service.findAll();
				System.out.println("进入列表");
				request.setAttribute("empdys", result.getData());
				//需要改变的地方，jsp
				request.getRequestDispatcher("/daoyou/e-listdaoyou.jsp").forward(request, response);
			}
			if("addempdy.dao".equals(url)) {
				EmpDaoyou e = new EmpDaoyou();
				e.setDyname(request.getParameter("dyname"));
				System.out.println(e.getDyname());
				e.setDytel(request.getParameter("dytel"));
				e.setDygender(request.getParameter("dygender"));
				
				System.out.println(e+"SI");
				service.addEmpDaoyou(e);
				response.sendRedirect("findAll.dao");
			}
			if("delete.dao".equals(url)) {
				int dynum = Integer.parseInt(request.getParameter("dynum"));
				service.deleteEmpDaoyou(dynum);
				response.sendRedirect("findAll.dao");
			}
			//改变量名
			if("update.dao".equals(url)) {
				EmpDaoyou e = new EmpDaoyou();
				e.setDynum(Integer.parseInt(request.getParameter("dynum")));
				e.setDyname(request.getParameter("dyname"));
				e.setDytel(request.getParameter("dytel"));
				e.setDygender(request.getParameter("dygender"));
				service.updateEmpDaoyou(e);
				response.sendRedirect("findAll.dao");
			}
			//改变量名和jsp
			if("findById.dao".equals(url)) {
				System.out.println("查询dynum");
				int dynum = Integer.parseInt(request.getParameter("dynum"));
				Result result = service.findById(dynum);
				request.setAttribute("empdy", result.getData());
				request.getRequestDispatcher("daoyou/updatedaoyou.jsp").forward(request, response);
			}
		}
}
