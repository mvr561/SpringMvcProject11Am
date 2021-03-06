package com.app.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Purchase;

public class PurchaseExcelView extends AbstractXlsxView{

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment;filename=Purchases.xlsx");

		
		List<Purchase> purchase=(List<Purchase>) model.get("purchase");
	
		Sheet sheet=workbook.createSheet("Purchases");
		
		setHead(sheet);
		setBody(sheet,purchase);
		
	}

	private void setHead(Sheet sheet) {

		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("CODE");
		row.createCell(2).setCellValue("MODE");
		row.createCell(3).setCellValue("VENDOR");
		row.createCell(4).setCellValue("REF NUM");
		row.createCell(5).setCellValue("QC");
		row.createCell(6).setCellValue("STATUS");
		row.createCell(7).setCellValue("NOTE");
	}
	
	private void setBody(Sheet sheet, List<Purchase> purchase) {

		int rowNumber=1;
		for(Purchase p:purchase) {
			Row row=sheet.createRow(rowNumber++);
			row.createCell(0).setCellValue(p.getOrderId().toString());
			row.createCell(1).setCellValue(p.getOrderCode());
			row.createCell(2).setCellValue(p.getShipmentMode());
			row.createCell(3).setCellValue(p.getVendor());
			row.createCell(4).setCellValue(p.getRefNumber());
			row.createCell(5).setCellValue(p.getQuaCheck());
			row.createCell(6).setCellValue(p.getOrderStatus());
			row.createCell(6).setCellValue(p.getOrderDesc());
		}
		
	}

	}
