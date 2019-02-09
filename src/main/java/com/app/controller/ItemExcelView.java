package com.app.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Item;


public class ItemExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//set our own name to excel
		response.setHeader("Content-Disposition", "attachment;filename=Items.xlsx");
		//get from Controller
  List<Item>	list=	(List<Item>) model.get("list");
		
  
  //create sheet
  Sheet s = workbook.createSheet("item");
  
  setHead(s);
  setBody(list,s);
  
  
	}

	private void setBody(List<Item> list, Sheet s) {
		int rn=1;
		
		for(Item i:list) {
			Row r = s.createRow(rn++);
			r.createCell(0).setCellValue(i.getItemId());
			r.createCell(1).setCellValue(i.getItemCode());
			r.createCell(2).setCellValue(i.getItemLength());
			r.createCell(3).setCellValue(i.getItemWidth());
			r.createCell(4).setCellValue(i.getItemHeight());
			r.createCell(5).setCellValue(i.getBaseCost());
			r.createCell(6).setCellValue(i.getBaseCurrency());
			r.createCell(7).setCellValue(i.getItemDsc());
			
			
			
		}
		
	}

	private void setHead(Sheet s) {
		
		Row row = s.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("CODE");
		row.createCell(2).setCellValue("LENGTH");
		row.createCell(3).setCellValue("WIDTH");
		row.createCell(4).setCellValue("HEIGHT");
		row.createCell(4).setCellValue("COST");
		row.createCell(4).setCellValue("CURRENCY");
		row.createCell(4).setCellValue("DESCRIPTION");
	
	}

}
