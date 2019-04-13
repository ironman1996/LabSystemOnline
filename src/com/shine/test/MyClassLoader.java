package com.shine.test;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import com.mathworks.toolbox.javabuilder.MWException;



public class MyClassLoader  {
    public static void main(String[] args) throws Exception {
    	File file = new File("E:/javaworkspace/demo/WebContent/WEB-INF/lib/plotTest.jar");//jar包的路径
		URL url = file.toURI().toURL();
		URLClassLoader loader = new URLClassLoader(new URL[]{url});//创建类加载器
		Class<?> cls = loader.loadClass("plotTest.PlotClass");//加载指定类，注意一定要带上类的包名
		Method[] m2=cls.getDeclaredMethods();
    	for(Method m:m2){
    		System.out.println(m);
    	}
    	Object[] a={},b={2};
		Method m1=cls.getDeclaredMethod("plotTest",Object[].class);
		System.out.println(cls);//输出"000chen000","chen"字符串两边各加3个"0"字符串
		Object obj=cls.newInstance();
	    m1.setAccessible(true);
		m1.invoke(obj,(Object)a);

    }
}