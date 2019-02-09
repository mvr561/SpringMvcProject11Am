package com.app.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.ShipmentType;
import com.app.model.Uom;
import com.app.model.WhUserType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class WhUserTypePdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		//set content file to download for not view
		response.setHeader("Content-Disposition", "attachement;filename=WhUserType.pdf");
		//get controller data to model

		List<WhUserType> st=	(List<WhUserType>) model.get("list");

		//write paragraph
		Paragraph p =new Paragraph("hello ravi ,this is ur data");

		document.add(p);

		//create table
		PdfPTable pf=new PdfPTable(8);
		//create table with our headings
		pf.addCell("ID");
		pf.addCell("TYPE");
		pf.addCell("CODE");
		pf.addCell("UFOR");
		pf.addCell("EMAIL");
		pf.addCell("CONTACT");
		pf.addCell("IDTYPE");
		pf.addCell("IFOTHER");
		



		//read data to excel table
		for(WhUserType s:st) {

			pf.addCell(s.getId().toString());
			pf.addCell(s.getUserType());
			pf.addCell(s.getUserCode());
			pf.addCell(s.getUserFor());
			pf.addCell(s.getUserEmail());
			pf.addCell(s.getUserContact());
			pf.addCell(s.getUserIdType());
			pf.addCell(s.getIfOther());
			



		}
		document.add(pf);

		document.add(new Paragraph(new Date().toString()));





	}

}


