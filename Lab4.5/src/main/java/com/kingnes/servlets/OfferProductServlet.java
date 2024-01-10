package com.kingnes.servlets;

import java.awt.geom.FlatteningPathIterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.kingnes.dao.CompanyDao;
import com.kingnes.dao.ProductDao;
import com.kingnes.services.DbCon;

@MultipartConfig
@WebServlet("/offer-product")
public class OfferProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List < FileItem > fields = upload.parseRequest(request);
			Iterator < FileItem > it = fields.iterator();
			
			String companyName = it.next().getString();
			String productName = it.next().getString();
			String category = it.next().getString();
			float price = Float.parseFloat(it.next().getString());

//			Part part = request.getPart("file");
//			String fileName = part.getSubmittedFileName();
			FileItem fileItem = it.next();
			if (fileItem.getSize() > 0) {
					fileItem.write(new File("D:\\Users\\vorte\\OneDrive\\Документы\\3_course_1_term\\JavaLabs\\Lab4.5\\src\\main\\webapp\\product-image\\" + fileItem.getName()));
			}
			
			ProductDao pdao = new ProductDao(DbCon.getConnection());
			pdao.insertProduct(productName, category, price, fileItem.getName());
			
			CompanyDao cdao = new CompanyDao(DbCon.getConnection());
			cdao.insertCompany(companyName);
			response.sendRedirect("index.jsp");
//			String path = getServletContext().getRealPath("/" + "product-image" + File.separator + fileName);
//			
//			InputStream is = part.getInputStream();
//			boolean result = uploadFile(is, path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean uploadFile(InputStream is, String path) {
		boolean result = false;
		try {
			byte[] byt = new byte[is.available()];
			is.read();
			FileOutputStream fops = new FileOutputStream(path);
			fops.write(byt);
			fops.flush();
			fops.close();

			result = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

}
