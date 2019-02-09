package com.app.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.ShipmentType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ShipmentTypePdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//set content file to download
		response.setHeader("Content-Disposition", "attachement;filename=SHIPMENTS.pdf");
		//get controller data to model
		
	   List<ShipmentType> st=	(List<ShipmentType>) model.get("list");
	   
	   //write paragraph
	   Paragraph p =new Paragraph("hello ravi ,this is ur data");
	   
	document.add(p);
	
	//create table
	PdfPTable pf=new PdfPTable(6);
	//create table with our headings
	pf.addCell("ID");
	pf.addCell("MODE");
	pf.addCell("CODE");
	pf.addCell("ENABLE");
	pf.addCell("GRADE");
	pf.addCell("DESC");
	
	
	
	//read data to excel
	for(ShipmentType s:st) {
		
		pf.addCell(s.getId().toString());
		pf.addCell(s.getShipmentMode());
		pf.addCell(s.getShipmentCode());
		pf.addCell(s.getEnableshipment());
		pf.addCell(s.getShipmentGrade());
		pf.addCell(s.getShipmentDesc());
		
		
		
		
	}
	document.add(pf);
	
	document.add(new Paragraph(new Date().toString()));
	
	
	
	
	
	}

}
