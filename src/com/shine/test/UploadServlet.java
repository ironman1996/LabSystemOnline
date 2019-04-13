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
		//1.得到FileItem集合Items
		DiskFileItemFactory factory =new DiskFileItemFactory();
		//设置内存中最多可以存放的上传文件的大小，若超出则把文件写道一个临时文件夹中
		factory.setSizeThreshold(1024*500);
		//设置那个临时文件夹
		File tempDirectory=new File("E:\\javaworkspace\\demo\\WebContent\\WEB-INF\\lib");
		factory.setRepository(tempDirectory);
		ServletFileUpload upload=new ServletFileUpload(factory);
		//设置上传文件总的大小
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
		//2.遍历items，若是一个一般的表单域，打印文档
		
		//3.
	}

}
