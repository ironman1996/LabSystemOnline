package com.shine.controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shine.entity.Result;
import com.shine.service.user.UserService;
import com.shine.service.user.UserServiceImpl;

/**
 * 规范：
 * 	1.继承自HttpServlet
 * 	2.必须有以下方法
 * 		doGet()
 * 		doPost()
 * 		或  service();
 * 			方法的参数  要有两个对象：
 * 				1.request
 * 				2.response
 * 			抛出两个异常
 * 				ServeltException
 * 				IOException
 * 			
 * @author xyd
 *
 */
public class UserServlet extends HttpServlet{
	
	
	public void service(HttpServletRequest request,
			HttpServletResponse response)throws ServletException,IOException{
		
		String username =request.getParameter("username");
		String password = request.getParameter("pwd");
		HttpSession session = request.getSession();
		String numberServlet = (String)session.getAttribute("number");
		String numberInput = request.getParameter("code");
		if(numberServlet.equalsIgnoreCase(numberInput)) {
			UserService service = new UserServiceImpl();
			Result result = service.checkUsername(username, password);
			session.setAttribute("user", result.getData());
			if(result.getStatus() !=0){
				//转发
				request.setAttribute("message", result.getMessage());
				request.setAttribute("username", username);
				request.setAttribute("pwd", password);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else{
				//转发
				//System.out.println("sdfsfsfsfsfsf");
				request.getRequestDispatcher("choosemessage.jsp").forward(request, response);
			}
		}else {
			//返回登录页面
			request.setAttribute("message", "验证码错误！");
			request.setAttribute("number", numberInput);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
		
		
		
	}

}
