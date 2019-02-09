package com.app.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.User;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UserPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.setHeader("Content-Disposition", "attachement;filename=Users.pdf");
	List<User> st=	(List<User>) model.get("list");
	
	
	List<User>   ts    =     (List<User>) model.get("list");
	Paragraph p = new Paragraph("hii ravi");
	document.add(p);
	PdfPTable pf = new PdfPTable(5);
	 pf.addCell("ID");
	 pf.addCell("NAME");
	 pf.addCell("EMAIL");
	 pf.addCell("PASSWORD");
	 //pf.addCell("ROLES");
	 pf.addCell("CONTACT");
	 
	for(User u:ts) {
		
		 pf.addCell(u.getUserId().toString());
		 pf.addCell(u.getUserName());
		 pf.addCell(u.getUserEmail());
		 pf.addCell(u.getUserPwd());
		 //pf.addCell((PdfPCell) u.getRoles());
		 pf.addCell(u.getMobile());
		
		
		 
	}	
	 document.add(pf);
	}

}
