package com.app.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.ShipmentType;

public class ShipmentTypeExcelView extends AbstractXlsxView {

	
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//set our own name to excel
		response.setHeader("Content-Disposition", "attachment;filename=SHIPMENTS.xlsx");
		
		//reading data from model
		List<ShipmentType> list=(List<ShipmentType>) model.get("list");
		
		//creating sheet
		
		Sheet sheet=workbook.createSheet("ShipmentTypes");
		
		//create own methods 
		//set HeadRow#O
		setHead(sheet);
		
		//set body row#1
		setBody(sheet,list);
		
	}

	private void setBody(Sheet sheet,List<ShipmentType> list) {
		int rowNum=1;
		for(ShipmentType s:list) {
		Row row = sheet.createRow(rowNum++);
		row.createCell(0).setCellValue(s.getId());
		row.createCell(1).setCellValue(s.getShipmentMode());
		row.createCell(2).setCellValue(s.getShipmentCode());
		row.createCell(3).setCellValue(s.getEnableshipment());
		row.createCell(4).setCellValue(s.getEnableshipment());
		row.createCell(5).setCellValue(s.getShipmentDesc());
		}
	}

	private void setHead(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("MODE");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("ENABLE");
		row.createCell(4).setCellValue("GRADE");
		row.createCell(5).setCellValue("NOTE");
		
	}

}
