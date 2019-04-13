package com.shine.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//画验证码图片
		BufferedImage image =  new BufferedImage(80,30, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setColor(new Color(255,255,255));
		g.fillRect(0, 0, 80, 30);
		String number = getCode(4);
		HttpSession session = request.getSession();
		session.setAttribute("number", number);
		g.setColor(getRandomColor());
		g.setFont(new Font("微软雅黑",Font.ITALIC,18));
		g.drawString(number, 5, 24);
		
		for(int i =0;i<10;i++) {
			Random r = new Random();
			g.setColor(getRandomColor());
			g.drawLine(r.nextInt(80), r.nextInt(30), r.nextInt(80), r.nextInt(30));
		}
		
		
		response.setContentType("image/jpeg");
		OutputStream os = response.getOutputStream();
		javax.imageio.ImageIO.write(image, "jpeg", os);
	}
	
	/**
	 * 生成随机字符串
	 * @param size
	 * @return
	 */
	public static String getCode(int size) {
		String number = "";
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random r = new Random();
		for(int i = 0;i<size;i++) {
			number = number+chars.charAt(r.nextInt(chars.length()));
		}
		
		return number;
		
	}
	
	/**
	 * 获取随机颜色
	 * @return
	 */
	public static Color getRandomColor() {
		
		Random r = new Random();
		Color color = new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
		
		return color;
		
	}
	public static void main(String[] args) {
		System.out.println(getCode(4));
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
