package com.kidscodetw.eeit.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/photo.do")
public class PhotoController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("image/jpeg");
		String type_raw = request.getParameter("type");
		String type = type_raw.substring(0, 1).toUpperCase() + type_raw.substring(1);
		String id = request.getParameter("id");
		String imgName = type + id;
		ServletContext context = getServletContext();
		File f = new File(context.getRealPath("/") + "/photo/" + imgName + ".jpg");
		if (f.exists()) {
			writeImgToBrowser(response, imgName);
		} else {
			makeImgFromDb(type, id);
			if (f.exists()) {
				writeImgToBrowser(response, imgName);
			}
		}

	}

	public void writeImgToBrowser(HttpServletResponse response, String imgName) throws IOException {
		ServletContext context = getServletContext();
		String path = context.getRealPath("/photo/" + imgName + ".jpg");
		File photo = new File(path);
		FileInputStream fin = new FileInputStream(photo);
		OutputStream out = response.getOutputStream();
		BufferedInputStream bin = new BufferedInputStream(fin);
		BufferedOutputStream bout = new BufferedOutputStream(out);
		int length = 0;
		;
		while ((length = bin.read()) != -1) {
			bout.write(length);
		}
		bin.close();
		fin.close();
		bout.close();
		out.close();
	}

	public void makeImgFromDb(String type, String id) {
		Connection conn = CommonUtil.connectMysql();
		ServletContext context = getServletContext();
		FileOutputStream out = null;
		Blob blob = null;
		try {
			PreparedStatement pstat = conn.prepareStatement("SELECT photo from " + type + " WHERE id =" + id);
			ResultSet rs = pstat.executeQuery();
			if (rs.next()) {

				blob = rs.getBlob(1);
			}
			if (blob != null) {
				InputStream is = blob.getBinaryStream();
				String path = context.getRealPath("/photo/" + type + id + ".jpg");
				File img = new File(path);

				try {
					out = new FileOutputStream(img);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				try {
					BufferedInputStream bin = new BufferedInputStream(is);
					BufferedOutputStream bout = new BufferedOutputStream(out);
					int length = 0;
					;
					while ((length = bin.read()) != -1) {
						bout.write(length);
					}
					bin.close();
					is.close();
					bout.close();
					out.close();
					rs.close();
					conn.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
