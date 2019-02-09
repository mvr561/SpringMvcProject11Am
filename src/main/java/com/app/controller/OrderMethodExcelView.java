package com.app.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.OrderMethod;

public class OrderMethodExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//set our own name to excel
				response.setHeader("Content-Disposition", "attachment;filename=ORDERMETHODS.xlsx");
				
		//casting required because of object type
		List<OrderMethod> list= (List<OrderMethod>) model.get("list");
		
		Sheet sheet=workbook.createSheet("omethod");
		
		//create our own methods
		//create method row head#0
		setHead(sheet);
		//setBody
		setBody(sheet,list);
		
	}

	private void setBody(Sheet sheet, List<OrderMethod> list) {
		int rown=1;
		for(OrderMethod o:list) {
		Row row = sheet.createRow(rown++);
		row.createCell(0).setCellValue(o.getId());
		row.createCell(1).setCellValue(o.getOrderMode());
		row.createCell(2).setCellValue(o.getOrderCode());
		row.createCell(3).setCellValue(o.getOrderAccept()!=null?o.getOrderAccept().toString():"[]");
		row.createCell(4).setCellValue(o.getOrderDsc());
		}
		
		
	}

	private void setHead(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("MODE");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("TYPE");
		row.createCell(4).setCellValue("DESC");
		
	}

}
