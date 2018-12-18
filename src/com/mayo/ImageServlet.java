package com.mayo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 创建图片缓存区
		BufferedImage bi = new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB);
		// 创建绘制环境，相当于拿起画笔
		Graphics g = bi.getGraphics();
		// 设置画笔
		Color c = new Color(200, 150, 225);
		g.setColor(c);
		// 画背景
		g.fillRect(0, 0, 68, 22);
		// 画内容
		// 设置文本
		char[] ch = "QWERTYUIOPASDFGHJKLZXCVBNM1234567890".toCharArray();
		// 生成随机数
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		int len = ch.length, index;
		for (int i = 0; i < 4; i++) {
			index = r.nextInt(len);
			g.setColor(new Color(r.nextInt(88), r.nextInt(188), r.nextInt(255)));
			// 画字符
			g.drawString(ch[index] + "", (i * 15) + 3, 18);
			sb.append(ch[index]);
		}
		request.getSession().setAttribute("piccode", sb.toString());
		// 输出图片
		ImageIO.write(bi, "JPG", response.getOutputStream());

	}

}
