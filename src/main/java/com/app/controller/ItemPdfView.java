package com.app.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Item;
import com.app.model.OrderMethod;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ItemPdfView extends AbstractPdfView {

	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		//set content file to download for not view
		response.setHeader("Content-Disposition", "attachement;filename=Item.pdf");
		//get controller data to model

		List<Item> st=	(List<Item>) model.get("list");

		//write paragraph
		Paragraph p =new Paragraph("hello ravi ,this is ur data"+"<br>");

		document.add(p);

		//create table
		PdfPTable pf=new PdfPTable(8);
		//create table with our headings
		pf.addCell("ID");
		pf.addCell("CODE");
		pf.addCell("LENGTH");
		pf.addCell("WIDTH");
		pf.addCell("HEIGHT");
		pf.addCell("COST");
		pf.addCell("CURRENCY");
		pf.addCell("DISCRIPTION");



		//read data to excel table
		for(Item s:st) {

			pf.addCell(s.getItemId().toString());
			pf.addCell(s.getItemCode());
			pf.addCell(s.getItemLength()+"(length)");
			pf.addCell(s.getItemWidth()+"(width)");
			pf.addCell(s.getItemHeight()+"(height)");
			pf.addCell(s.getBaseCost().toString());
			pf.addCell(s.getBaseCurrency());
			pf.addCell(s.getItemDsc());
			



		}
		document.add(pf);

		document.add(new Paragraph(new Date().toString()));





	}

}
