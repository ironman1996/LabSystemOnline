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
 * �淶��
 * 	1.�̳���HttpServlet
 * 	2.���������·���
 * 		doGet()
 * 		doPost()
 * 		��  service();
 * 			�����Ĳ���  Ҫ����������
 * 				1.request
 * 				2.response
 * 			�׳������쳣
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
				//ת��
				request.setAttribute("message", result.getMessage());
				request.setAttribute("username", username);
				request.setAttribute("pwd", password);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else{
				//ת��
				//System.out.println("sdfsfsfsfsfsf");
				request.getRequestDispatcher("choosemessage.jsp").forward(request, response);
			}
		}else {
			//���ص�¼ҳ��
			request.setAttribute("message", "��֤�����");
			request.setAttribute("number", numberInput);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
		
		
		
	}

}
