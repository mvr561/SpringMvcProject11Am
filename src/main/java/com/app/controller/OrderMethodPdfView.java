package com.app.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.OrderMethod;
import com.app.model.ShipmentType;
import com.app.model.Uom;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class OrderMethodPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		//set content file to download for not view
		response.setHeader("Content-Disposition", "attachement;filename=ORDERMETHOD.pdf");
		//get controller data to model

		List<OrderMethod> st=	(List<OrderMethod>) model.get("list");

		//write paragraph
		Paragraph p =new Paragraph("hello ravi ,this is ur data");

		document.add(p);

		//create table
		PdfPTable pf=new PdfPTable(6);
		//create table with our headings
		pf.addCell("ID");
		pf.addCell("TYPE");
		pf.addCell("MODE");
		pf.addCell("CODE");
		pf.addCell("DESC");
		pf.addCell("ACCEPT");



		//read data to excel table
		for(OrderMethod s:st) {

			pf.addCell(s.getId().toString());
			pf.addCell(s.getExeType());
			pf.addCell(s.getOrderMode());
			pf.addCell(s.getOrderCode());
			pf.addCell(s.getOrderDsc());
			pf.addCell(s.getOrderAccept().toString());



		}
		document.add(pf);

		document.add(new Paragraph(new Date().toString()));





	}

}


