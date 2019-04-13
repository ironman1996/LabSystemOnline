package com.shine.controller.jingdian;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shine.entity.EmpJingdian;
import com.shine.entity.Result;
import com.shine.entity.User;
import com.shine.service.jingdian.JingdianService;
import com.shine.service.jingdian.JingdianServiceImpl;



@WebServlet("*.jing")
public class JingdianServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		String url = request.getRequestURI();
		String[] strs = url.split("/");
		url = strs[strs.length-1];
		System.out.println(url);
		JingdianService service = new JingdianServiceImpl();
		HttpSession session = request.getSession();
		EmpJingdian user = (EmpJingdian)session.getAttribute("EmpJingdian");
			if("findAll.jing".equals(url)) {
				
				Result result = service.findAll();
				System.out.println(123);
				request.setAttribute("empjds", result.getData());
				request.getRequestDispatcher("/jingdian/listjingdian.jsp").forward(request, response);
			}
			if("efindAll.jing".equals(url)) {
				
				Result result = service.findAll();
				System.out.println(123);
				request.setAttribute("empjds", result.getData());
				request.getRequestDispatcher("/jingdian/e-listjingdian.jsp").forward(request, response);
			}
			if("addempjd.jing".equals(url)) {
				EmpJingdian e = new EmpJingdian();
				e.setJdname(request.getParameter("jdname"));
				e.setJdtel(request.getParameter("jdtel"));
				System.out.println(request.getParameter("jdtel"));
				e.setJdpj(request.getParameter("jdpj"));
				e.setJdprice(Integer.parseInt(request.getParameter("jdprice")));
				e.setJdaddress(request.getParameter("jdaddress"));
				
				System.out.println(e);
				service.addEmpJingdian(e);
				response.sendRedirect("findAll.jing");
			}
			if("delete.jing".equals(url)) {
				int jdnum = Integer.parseInt(request.getParameter("jdnum"));
				service.deleteEmpJingdian(jdnum);
				response.sendRedirect("findAll.jing");
			}
			if("update.jing".equals(url)) {
				EmpJingdian e = new EmpJingdian();
				System.out.println(request.getParameter("jdnum"));
				e.setJdnum(Integer.parseInt(request.getParameter("jdnum")));
				e.setJdname(request.getParameter("jdname"));
				e.setJdtel(request.getParameter("jdtel"));
				e.setJdpj(request.getParameter("jdpj"));
				e.setJdprice(Integer.parseInt(request.getParameter("jdprice")));
				e.setJdaddress(request.getParameter("jdaddress"));
				service.updateEmpJingdian(e);
				response.sendRedirect("findAll.jing");
			}
			if("findById.jing".equals(url)) {
				System.out.println("≤È—Øjdnum");
				int jdnum = Integer.parseInt(request.getParameter("jdnum"));
				Result result = service.findById(jdnum);
				request.setAttribute("empjd", result.getData());
				request.getRequestDispatcher("jingdian/updatejingdian.jsp").forward(request, response);
			}
		}
}
