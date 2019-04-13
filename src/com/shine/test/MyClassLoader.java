package com.shine.test;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import com.mathworks.toolbox.javabuilder.MWException;



public class MyClassLoader  {
    public static void main(String[] args) throws Exception {
    	File file = new File("E:/javaworkspace/demo/WebContent/WEB-INF/lib/plotTest.jar");//jar����·��
		URL url = file.toURI().toURL();
		URLClassLoader loader = new URLClassLoader(new URL[]{url});//�����������
		Class<?> cls = loader.loadClass("plotTest.PlotClass");//����ָ���࣬ע��һ��Ҫ������İ���
		Method[] m2=cls.getDeclaredMethods();
    	for(Method m:m2){
    		System.out.println(m);
    	}
    	Object[] a={},b={2};
		Method m1=cls.getDeclaredMethod("plotTest",Object[].class);
		System.out.println(cls);//���"000chen000","chen"�ַ������߸���3��"0"�ַ���
		Object obj=cls.newInstance();
	    m1.setAccessible(true);
		m1.invoke(obj,(Object)a);

    }
}