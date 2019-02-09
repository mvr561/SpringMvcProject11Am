package com.app.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.ShipmentType;
import com.app.model.Uom;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UomPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		//set content file to download for not view
		response.setHeader("Content-Disposition", "attachement;filename=UOM.pdf");
		//get controller data to model

		List<Uom> st=	(List<Uom>) model.get("list");

		//write paragraph
		Paragraph p =new Paragraph("hello ravi ,this is ur data");

		document.add(p);

		//create table
		PdfPTable pf=new PdfPTable(4);
		//create table with our headings
		pf.addCell("ID");
		pf.addCell("TYPE");
		pf.addCell("MODEL");
		pf.addCell("DESC");



		//read data to excel table
		for(Uom s:st) {

			pf.addCell(s.getUomId().toString());
			pf.addCell(s.getUomType());
			pf.addCell(s.getUomModel());
			pf.addCell(s.getUomDsc());



		}
		document.add(pf);

		document.add(new Paragraph(new Date().toString()));





	}

}


