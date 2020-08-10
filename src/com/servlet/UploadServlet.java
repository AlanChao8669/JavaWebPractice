package com.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */
//@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		File file = null;
		String fileDescription = null;
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
		PrintWriter out = response.getWriter();

		try {
			List<FileItem> list = servletFileUpload.parseRequest(request);

			for (FileItem fileItem : list) {
				// whether or not a FileItem instance represents a simple form field
				if (fileItem.isFormField()) { // the instance represents a simple form field
					this.log("---------------------檢測到文件上傳說明...");
					fileDescription = new String(fileItem.getString().getBytes(), "UTF-8");
				} else { // the instance represents an upload file
					this.log("---------------------檢測到上傳檔案");

					File remoteFile = new File(new String(fileItem.getName().getBytes(), "UTF-8"));
//					this.log("用戶端檔案位址:" + file.getAbsolutePath());

					file = new File(this.getServletContext().getRealPath("attachment"), remoteFile.getName());
					file.getParentFile().mkdirs();
					file.createNewFile();

					InputStream ins = fileItem.getInputStream();
					OutputStream ous = new FileOutputStream(file);

					try {
						byte[] buffer = new byte[1024];
						int len = 0;
						while ((len = ins.read(buffer)) > -1) {
							ous.write(buffer, 0, len);
						}
						this.log("已儲存檔案: " + file.getAbsolutePath());
					} finally {
						ous.close();
						ins.close();
					}

				}
			}
			this.log("Request 解析完畢");
		} catch (FileUploadException e) {
			this.log("file upload exception.");
		}

		// 將檔案連結與說明印出到頁面上
		if (file != null) {
			out.println("<a href='" + request.getContextPath() + "/attachment/" + file.getName() + "' target=_blank>"
					+ file.getName() + "</a>");
		}
		out.println("<br/>");
		out.println(fileDescription);

	}

}
