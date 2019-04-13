package com.shine.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/uploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.�õ�FileItem����Items
		DiskFileItemFactory factory =new DiskFileItemFactory();
		//�����ڴ��������Դ�ŵ��ϴ��ļ��Ĵ�С������������ļ�д��һ����ʱ�ļ�����
		factory.setSizeThreshold(1024*500);
		//�����Ǹ���ʱ�ļ���
		File tempDirectory=new File("E:\\javaworkspace\\demo\\WebContent\\WEB-INF\\lib");
		factory.setRepository(tempDirectory);
		ServletFileUpload upload=new ServletFileUpload(factory);
		//�����ϴ��ļ��ܵĴ�С
		upload.setSizeMax(1024*1024*500);
		try {
			List<FileItem>  items=upload.parseRequest(request);
			for(FileItem item: items){
				if(item.isFormField()){
					String name=item.getFieldName();
					String value=item.getString();
					System.out.println(name+":  "+value);
				}
				else{
					String fieldName=item.getFieldName();
				     String fileName=item.getName();
				     fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
				     String contentType=item.getContentType();
				     boolean isInMemory=item.isInMemory();
				     long sizeInBytes=item.getSize();
				     System.out.println(fieldName);
				     System.out.println(fileName);
				     System.out.println(contentType);
				     System.out.println(sizeInBytes);
				     InputStream in=item.getInputStream();
				     byte [] buffer=new byte[1024];
				     int len=0;
				     fileName="E:\\javaworkspace\\demo\\WebContent\\WEB-INF\\lib\\"+fileName;
				     System.out.println(fileName);
				     OutputStream out=new FileOutputStream(fileName);
				     while((len=in.read(buffer))!=-1){
				    	 out.write(buffer,0,len);
				     }
				     out.close();
				     in.close();
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2.����items������һ��һ��ı��򣬴�ӡ�ĵ�
		
		//3.
	}

}
