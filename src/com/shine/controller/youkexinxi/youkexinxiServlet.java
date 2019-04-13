package com.shine.controller.youkexinxi;

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
import com.shine.entity.youkexinxi;
import com.shine.service.emp.EmpService;
import com.shine.service.emp.EmpServiceImpl;
import com.shine.service.user.UserService;
import com.shine.service.user.UserServiceImpl;
import com.shine.service.youkexinxi.youkexinxiService;
import com.shine.service.youkexinxi.youkexinxiServiceImpl;
public class youkexinxiServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	
		String youkexingming =request.getParameter("youkexingming");
			String youkemima = request.getParameter("youkemima");
			HttpSession session = request.getSession();
			System.out.println(youkexingming+youkemima);
			String numberServlet = (String)session.getAttribute("number");
			String numberInput = request.getParameter("code");
			if(numberServlet.equalsIgnoreCase(numberInput)) {
				youkexinxiServiceImpl service =  new youkexinxiServiceImpl();
				System.out.println(youkemima+1);
				Result result = service.checkUsername(youkexingming, youkemima);
				session.setAttribute("youkexinxi", result.getData());
				if(result.getStatus() !=0){
					//转发
					request.setAttribute("message", result.getMessage());
					request.setAttribute("youkexxingming", youkexingming);
					request.setAttribute("youkemima", youkemima);
					request.getRequestDispatcher("/e-login.jsp").forward(request, response);
				}else{
					//转发
					request.getRequestDispatcher("/emp-choosemessage.jsp").forward(request, response);
				}
			}else {
				//返回登录页面
				request.setAttribute("message", "验证码错误！");
				request.setAttribute("number", numberInput);
				request.getRequestDispatcher("/e-login.jsp").forward(request, response);
			}
		
	}
	

}
