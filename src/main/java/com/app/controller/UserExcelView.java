package com.app.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.User;

public class UserExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		List<User> st   =       (List<User>) model.get("list"); 
		
		   Sheet s=workbook.createSheet("usersheet");
             //set our own methods
		
		   //set rowhead
		
		  setHead(s);
		  setBody(s,st);
		
	}

	private void setBody(Sheet s, List<User> st) {
		
		int rownum=1;
		for(User u:st) {
			
			Row r = s.createRow(rownum++);
			
			r.createCell(0).setCellValue(u.getUserId());
			
			r.createCell(1).setCellValue(u.getUserName());
			
			r.createCell(2).setCellValue(u.getUserEmail());
			
			r.createCell(3).setCellValue(u.getUserPwd());
			
			r.createCell(4).setCellValue(u.getRoles().toString());
			
			r.createCell(0).setCellValue(u.getMobile());
			
			
			
			
		}
		
	}

	private void setHead(Sheet s) {
		Row r= s.createRow(0);
		  
		r.createCell(0).setCellValue("ID");
		
		r.createCell(1).setCellValue("NAME");
		
		r.createCell(2).setCellValue("EMAIL");
		
		r.createCell(3).setCellValue("PASSWORD");
		
		r.createCell(4).setCellValue("ROLES");
		
		r.createCell(0).setCellValue("CONTACT");
		
		
		
	}

}
