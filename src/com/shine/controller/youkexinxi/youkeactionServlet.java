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
@WebServlet("*.you")
public class youkeactionServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String url = request.getRequestURI();
		String[] strs = url.split("/");
		url = strs[strs.length-1];
		System.out.println(url);
		youkexinxiServiceImpl service =  new youkexinxiServiceImpl();
		HttpSession session = request.getSession();
		youkexinxi user = (youkexinxi)session.getAttribute("youkexinxi");
		
			if("findAll.you".equals(url)) {
				//System.out.println("进入findyou");
				Result result = service.findAll();
				System.out.println(123855);
				request.setAttribute("youkexinxi", result.getData());
				request.getRequestDispatcher("/emp/listEmp.jsp").forward(request, response);
			}
			
			if("zhuce.you".equals(url)) {
				System.out.println("进入添加");
				youkexinxi e = new youkexinxi();
				
				e.setyoukexingming(request.getParameter("youkexingming"));
				e.setxingbie(request.getParameter("xingbie"));
				e.setshenfengzhenghao(request.getParameter("shenfengzhenghao"));
				e.setlianxifangshi(request.getParameter("lianxifangshi"));
				e.setyoukemima(request.getParameter("youkemima"));
				System.out.println(request.getParameter("youkemima"));
				System.out.println(e);
				service.addyoukexinxi(e);
				response.sendRedirect("/demo/e-login.jsp");
			}
			if("addyoukexinxi.you".equals(url)) {
				System.out.println("进入添加");
				youkexinxi e = new youkexinxi();
				
				e.setyoukexingming(request.getParameter("youkexingming"));
				e.setxingbie(request.getParameter("xingbie"));
				e.setshenfengzhenghao(request.getParameter("shenfengzhenghao"));
				e.setlianxifangshi(request.getParameter("lianxifangshi"));
				e.setyoukemima(request.getParameter("youkemima"));
				System.out.println(request.getParameter("youkemima"));
				System.out.println(e);
				service.addyoukexinxi(e);
				response.sendRedirect("findAll.you");
			}
			if("delete.you".equals(url)) {
				System.out.println(request.getParameter("youkebianhao"));
				System.out.println(request.getParameter("youkexingming"));
				int youkebianhao = Integer.parseInt(request.getParameter("youkebianhao"));
				System.out.println(youkebianhao);
				service.deleteyoukexinxi(youkebianhao);
				response.sendRedirect("findAll.you");
			}
			if("update.you".equals(url)) {
				youkexinxi e = new youkexinxi();
				System.out.println("进入添加");
				e.setyoukexingming(request.getParameter("youkexingming"));
				e.setyoukebianhao(Integer.parseInt(request.getParameter("youkebianhao")));
				e.setxingbie(request.getParameter("xingbie"));
				e.setshenfengzhenghao(request.getParameter("shenfengzhenghao"));
				//System.out.print(request.getParameter("lianxifangshi"));
				e.setlianxifangshi(request.getParameter("lianxifangshi"));
				e.setyoukemima(request.getParameter("youkemima"));
				System.out.print(e);
				System.out.println("爱你");
				service.updateyoukexinxi(e);
				response.sendRedirect("findAll.you");
			}
			if("findById.you".equals(url)) {
				System.out.println("查询id");
				System.out.println(request.getParameter("youkebianhao"));
				int youkebianhao = Integer.parseInt(request.getParameter("youkebianhao"));
				
				
				Result result = service.findById(youkebianhao);
				request.setAttribute("youkexinxi", result.getData());
				request.getRequestDispatcher("/emp/updateEmp.jsp").forward(request, response);
			}
		
	}
}
