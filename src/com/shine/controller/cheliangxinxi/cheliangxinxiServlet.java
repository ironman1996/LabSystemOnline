package com.shine.controller.cheliangxinxi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shine.entity.Result;
import com.shine.entity.cheliangxinxi;
import com.shine.entity.youkexinxi;
import com.shine.service.cheliangxinxi.cheliangxinxiServiceImpl;

/**
 * Servlet implementation class cheliangxinxiServlet
 */
@WebServlet("*.che")
public class cheliangxinxiServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String url = request.getRequestURI();
		String[] strs = url.split("/");
		url = strs[strs.length-1];
		System.out.println(url);
		cheliangxinxiServiceImpl service =  new cheliangxinxiServiceImpl();
		HttpSession session = request.getSession();
		cheliangxinxi user = (cheliangxinxi)session.getAttribute("cheliangxinxi");
		
            
		if("eche.che".equals(url)) {
			
			Result result = service.findAll();
			System.out.println("Ñô¸ç×îË§");
			request.setAttribute("cheliangxinxi", result.getData());
			request.getRequestDispatcher("/car/e-listCar.jsp").forward(request, response);
		}
		
			if("findAll.che".equals(url)) {
				
				Result result = service.findAll();
				System.out.println("Ñô¸ç×îË§");
				request.setAttribute("cheliangxinxi", result.getData());
				request.getRequestDispatcher("/car/listCar.jsp").forward(request, response);
			}
			if("addcheliangxinxi.che".equals(url)) {
				System.out.println("½øÈëÌí¼Ó");
				cheliangxinxi e = new cheliangxinxi();
				
				e.setChepaihao(request.getParameter("chepaihao"));
				e.setJinrushijian(request.getParameter("jinrushijian"));
				e.setLikaishijian(request.getParameter("likaishijian"));
				
				
				System.out.println(e);
				service.addcheliangxinxi(e);
				response.sendRedirect("findAll.che");
			}
			if("delete.che".equals(url)) {
				System.out.println(request.getParameter("cheliangbianhao"));
				
				int cheliangbianhao = Integer.parseInt(request.getParameter("cheliangbianhao"));
				System.out.println(cheliangbianhao);
				service.deletecheliangxinxi(cheliangbianhao);
				response.sendRedirect("findAll.che");
			}
			if("update.che".equals(url)) {
				cheliangxinxi e = new cheliangxinxi();
				
				System.out.println(e.getCheliangbianhao()+"SL");
				e.setCheliangbianhao(Integer.parseInt(request.getParameter("cheliangbianhao")));
				
				e.setChepaihao(request.getParameter("chepaihao"));
				e.setJinrushijian(request.getParameter("jinrushijian"));
				e.setLikaishijian(request.getParameter("likaishijian"));
				
				System.out.println("°®Äã");
				service.updatecheliangxinxi(e);
				response.sendRedirect("cheliangxinxi/findAll.che");
			}
			if("findById.che".equals(url)) {
				System.out.println("²éÑ¯id");
				System.out.println(request.getParameter("cheliangbianhao"));
				int cheliangbianhao = Integer.parseInt(request.getParameter("cheliangbianhao"));
				Result result = service.findById(cheliangbianhao);
				request.setAttribute("cheliangxinxi", result.getData());
				request.getRequestDispatcher("/car/updateCar.jsp").forward(request, response);
			}
		}

	private int Integer(String parameter) {
		// TODO Auto-generated method stub
		return 0;
	}
		
}
