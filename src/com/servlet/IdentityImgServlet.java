package com.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * Servlet implementation class IdentityImgServlet
 */
//@WebServlet(description = "圖形驗證處理servlet", urlPatterns = { "/IdentityImgServlet" })
public class IdentityImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final char[] CHARS = { '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
			'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private static final int IDENTITY_LENGTH = 6;
	private static Random random = new Random();

	private static String getRandomString() {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < IDENTITY_LENGTH; i++) {
			char randomChar = CHARS[random.nextInt(CHARS.length)];
			buffer.append(randomChar);
		}
		return buffer.toString();
	}

	private static ArrayList<Color> getRandomColor() {
		ArrayList<Color> color = new ArrayList();
		Color fontColor = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
		Color bgColor = new Color(255 - fontColor.getRed(), 255 - fontColor.getGreen(), 255 - fontColor.getBlue());
		color.add(fontColor);
		color.add(bgColor);
		return color;
	}

	private static BufferedImage generateImg(String str) {
		int width = 100;
		int height = 30;
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = img.createGraphics();
		// setting of image
		ArrayList<Color> color = getRandomColor();
		g.setColor(color.get(0));
		g.fillRect(0, 0, width, height);
		g.setColor(color.get(1));
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		g.drawString(str, 18, 20);
		// draw noise dots
		for (int i = 0, n = (25 + random.nextInt(20)); i < n; i++) {
			g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
		}
		return img;
	}

	public IdentityImgServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("image/jpeg");

		String randomString = getRandomString();
		BufferedImage img = generateImg(randomString);

		ServletOutputStream out = response.getOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		encoder.encode(img);
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
