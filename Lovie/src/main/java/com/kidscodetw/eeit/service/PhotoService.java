package com.kidscodetw.eeit.service;

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
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kidscodetw.eeit.util.CommonUtil;

@Controller
@RequestMapping("photo")
public class PhotoService {

	@Autowired
	private ServletContext context;

	@Autowired
	private DataSource dataSource;

	@RequestMapping(value = "/{type}/{id}", method = RequestMethod.GET)
	protected void getPhoto(@PathVariable("type") String type,
			@PathVariable("id") String id, HttpServletResponse response) {
		response.setContentType("image/jpeg");
		type = type.substring(0, 1).toUpperCase() + type.substring(1);
		String imgName = type.substring(0, 1).toUpperCase() + type.substring(1)
				+ id;
		File f = new File(context.getRealPath("/") + "/photo/" + imgName
				+ ".jpg");
		if (f.exists()) {
			try {
				writeImgToBrowser(response, imgName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			makeImgFromDb(type, id);
			if (f.exists()) {
				try {
					writeImgToBrowser(response, imgName);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void writeImgToBrowser(HttpServletResponse response, String imgName)
			throws IOException {
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

		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}

		FileOutputStream out = null;
		Blob blob = null;
		type = type.substring(0, 1).toUpperCase() + type.substring(1);
		try {
			PreparedStatement pstat = conn
					.prepareStatement("SELECT photo from " + type
							+ " WHERE id =" + id);
			ResultSet rs = pstat.executeQuery();
			if (rs.next()) {

				blob = rs.getBlob(1);
			}
			if (blob != null) {
				InputStream is = blob.getBinaryStream();
				String path = context.getRealPath("/photo/" + type + id
						+ ".jpg");
				File img = new File(path);
				img.getParentFile().mkdirs();
				try {
					img.createNewFile();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				try {
					out = new FileOutputStream(img);
				} catch (FileNotFoundException e) {
					System.out.println(path + " not found.");
				}
				try {
					BufferedInputStream bin = new BufferedInputStream(is);
					BufferedOutputStream bout = new BufferedOutputStream(out);
					int length = 0;
					while ((length = bin.read()) != -1) {
						if (bout != null) {
							bout.write(length);
						}
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
