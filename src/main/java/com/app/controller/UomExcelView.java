package com.app.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Uom;

public class UomExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//set our own name to excel
				response.setHeader("Content-Disposition", "attachment;filename=UOMS.xlsx");
				

		//read data from db
		List<Uom> list= (List<Uom>) model.get("list");


		//creating sheet
		Sheet sheet=workbook.createSheet("Uom");

		//create our own methods
		//set headRow#0
		setHead(sheet);
		//set BOdyrow
		setBody(sheet,list);
	}

	private void setBody(Sheet sheet, List<Uom> list) {
        
		int rownum=1;
		for(Uom u:list) {
		Row row= sheet.createRow(rownum++);

		row.createCell(0).setCellValue(u.getUomId());
		row.createCell(1).setCellValue(u.getUomType());
		row.createCell(2).setCellValue(u.getUomModel());
		row.createCell(3).setCellValue(u.getUomDsc());

	}
	}

	private void setHead(Sheet sheet) {
		Row row= sheet.createRow(0);


		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("TYPE");
		row.createCell(2).setCellValue("MODEL");
		row.createCell(3).setCellValue("DESC");

	}




}
