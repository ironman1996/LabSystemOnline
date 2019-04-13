package com.shine.controller.matlab;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import java.net.URL;
import java.net.URLClassLoader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shine.entity.Emp;
import com.shine.entity.EmpJingdian;
import com.shine.entity.Matlab;
import com.shine.entity.Result;
import com.shine.entity.User;
import com.shine.entity.youkexinxi;
import com.shine.service.Matlab.MatlabService;
import com.shine.service.Matlab.MatlabServiceImpl;
import com.shine.service.emp.EmpService;
import com.shine.service.emp.EmpServiceImpl;
import com.shine.service.jingdian.JingdianService;
import com.shine.service.jingdian.JingdianServiceImpl;
import com.shine.service.user.UserService;
import com.shine.service.user.UserServiceImpl;
import com.shine.service.youkexinxi.youkexinxiService;
import com.shine.service.youkexinxi.youkexinxiServiceImpl;
@WebServlet("*.mat")
public class MatlabServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		String url1 = request.getRequestURI();
		String[] strs = url1.split("/");
		url1 = strs[strs.length-1];
		System.out.println(url1);
		MatlabService service = new MatlabServiceImpl();
		HttpSession session = request.getSession();
		Matlab user = (Matlab)session.getAttribute("Matlab");
			if("findAll.mat".equals(url1)) {
				
				Result result = service.findAll();
				System.out.println(result.getData());
				request.setAttribute("Matlab", result.getData());
				request.getRequestDispatcher("/Matlab/listMatlab.jsp").forward(request, response);
			}
			if("e-findAll.mat".equals(url1)) {
				
				Result result = service.findAll();
				System.out.println(result.getData());
				request.setAttribute("Matlab", result.getData());
				request.getRequestDispatcher("/matlab/listMatlab.jsp").forward(request, response);
			}
			if("addMatlab.mat".equals(url1)) {
				Matlab e = new Matlab();
				e.setMatPackageName(request.getParameter("matPackageName"));
				e.setMatDesc(request.getParameter("matDesc"));
				System.out.println(request.getParameter("matDesc"));
				e.setMatClass(request.getParameter("matClass"));
			
				e.setMatMethod(request.getParameter("matMethod"));
				
				System.out.println(e);
				service.addMatlab(e);
				response.sendRedirect("findAll.mat");
			}
			if("delete.mat".equals(url1)) {
				int matNum = Integer.parseInt(request.getParameter("matNum"));
				service.deleteMatlab(matNum);
				response.sendRedirect("findAll.mat");
			}
			if("update.mat".equals(url1)) {
				Matlab e = new Matlab();
				System.out.println(request.getParameter("matNum"));
				Result result = service.findAll();
				List<Matlab> mat=(List<Matlab>) result.getData();
				System.out.println(mat.get(0));
				e.setMatNum(Integer.parseInt(request.getParameter("matNum")));
				e.setMatPackageName(request.getParameter("matPackageName"));
				e.setMatDesc(request.getParameter("matDesc"));
				e.setMatClass(request.getParameter("matClass"));
				e.setMatMethod(request.getParameter("matMethod"));
				
				service.updateMatlab(e);
				response.sendRedirect("findAll.mat");
			}
			if("findById.mat".equals(url1)) {
				System.out.println("查询matNnum");
				int matNum = Integer.parseInt(request.getParameter("matNum"));
				Result result = service.findById(matNum);
				request.setAttribute("Matlab", result.getData());
				request.getRequestDispatcher("Matlab/updateMatlab.jsp").forward(request, response);
			}
			if("operate.mat".equals(url1)) {
				try {
					Class clazz=Class.forName("com.mathworks.toolbox.javabuilder.internal.MWComponentInstance");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("运行jar中的类");
				int matNum = Integer.parseInt(request.getParameter("matNum"));
				Matlab e = new Matlab();
				System.out.println(request.getParameter("matNum"));
				Result result = service.findAll();
				List<Matlab> mat=(List<Matlab>) result.getData();
				System.out.println(mat.get(0));
				String str=mat.get(0).toString();
				int i1=str.indexOf(",");
		        str=str.substring(i1+1);
		        i1=str.indexOf("=");
		        int i2=str.indexOf(",");
		        String matPackageName=str.substring(i1+1, i2);
		        str=str.substring(i2+1);
		        System.out.println(matPackageName);
		        System.out.println(str);
		        i1=str.indexOf("=");
		        i2=str.indexOf(",");
		        String matDesc=str.substring(i1+1, i2);
		        str=str.substring(i2+1);
		        System.out.println(matDesc);
		        System.out.println(str);
		        i1=str.indexOf("=");
		        i2=str.indexOf(",");
		        String matClass=str.substring(i1+1, i2);
		        str=str.substring(i2+1);
		        System.out.println(matClass);
		        System.out.println(str);
		        i1=str.indexOf("=");
		        i2=str.indexOf("]");
		        String matMethod=str.substring(i1+1, i2);
		        str=str.substring(i2+1);
		        System.out.println(matMethod);
		        System.out.println(str);
		        try{
		        	File file = new File("E:/javaworkspace/demo/WebContent/WEB-INF/lib/"+matPackageName+".jar");//jar包的路径
		    		URL url = file.toURI().toURL();
		    		URLClassLoader loader = new URLClassLoader(new URL[]{url},Thread.currentThread().getContextClassLoader());//创建类加载器
		    		Class<?> cls = loader.loadClass(matPackageName+"."+matClass);//加载指定类，注意一定要带上类的包名
		    		System.out.println(cls.getName());
		    		Method[] m2=cls.getDeclaredMethods();
		    		System.out.println(m2);
		        	for(Method m:m2){
		        		System.out.println(m);
		        	}
		        	Object[] a={},b={2};
		    		Method m1=cls.getDeclaredMethod(matMethod,Object[].class);
		    		System.out.println(m1+"这是要调用的函数");//输出"000chen000","chen"字符串两边各加3个"0"字符串
		    		Object obj=cls.newInstance();
		    	    m1.setAccessible(true);
		    		m1.invoke(obj,(Object)a);

					} 
		        catch(Exception e1){
		        	
		        }
			}
		}
}

