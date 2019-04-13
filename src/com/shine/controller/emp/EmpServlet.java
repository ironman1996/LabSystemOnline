package com.shine.controller.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shine.entity.Emp;
import com.shine.entity.Result;
import com.shine.entity.User;
import com.shine.service.emp.EmpService;
import com.shine.service.emp.EmpServiceImpl;


@WebServlet("*.do")
public class EmpServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String url = request.getRequestURI();
		String[] strs = url.split("/");
		url = strs[strs.length-1];
		System.out.println(url);
		EmpService service = new EmpServiceImpl();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user!=null) {
			if("findAll.do".equals(url)) {
				
				Result result = service.findAll();
				System.out.println(123);
				request.setAttribute("emps", result.getData());
				request.getRequestDispatcher("/emp/listEmp.jsp").forward(request, response);
			}
			if("addEmp.do".equals(url)) {
				Emp e = new Emp();
				e.setName(request.getParameter("name"));
				e.setSalary(Double.parseDouble(request.getParameter("salary")));
				e.setGender(request.getParameter("gender"));
				
				System.out.println(e);
				service.addEmp(e);
				response.sendRedirect("findAll.do");
			}
			if("delete.do".equals(url)) {
				int id = Integer.parseInt(request.getParameter("id"));
				service.deleteEmp(id);
				response.sendRedirect("findAll.do");
			}
			if("update.do".equals(url)) {
				Emp e = new Emp();
				e.setId(Integer.parseInt(request.getParameter("id")));
				e.setName(request.getParameter("name"));
				e.setSalary(Double.parseDouble(request.getParameter("salary")));
				e.setGender(request.getParameter("gender"));
				service.updateEmp(e);
				response.sendRedirect("findAll.do");
			}
			if("findById.do".equals(url)) {
				System.out.println("²éÑ¯id");
				int id = Integer.parseInt(request.getParameter("id"));
				Result result = service.findById(id);
				request.setAttribute("emp", result.getData());
				request.getRequestDispatcher("/emp/updateEmp.jsp").forward(request, response);
			}
		}else {
			//·Ç·¨µÇÂ¼
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
}
