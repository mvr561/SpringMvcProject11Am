package com.app.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.WhUserType;

public class WhUserTypeExcelView extends AbstractXlsxView {

	
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//set our own name to excel
				response.setHeader("Content-Disposition", "attachment;filename=WHUSERTYPES.xlsx");
				
		
		
		
		List<WhUserType> loc=(List<WhUserType>) model.get("ravi");
		
		
		Sheet s=workbook.createSheet("WhUserType");
		
		setBook(s);
		
		setBody(s,loc);
		
	}

	private void setBody(Sheet s, List<WhUserType> loc) {
	  
		int rc=1;
		for(WhUserType w:loc) {
			
			Row r = s.createRow(rc++);
			
			r.createCell(0).setCellValue(w.getId());
			r.createCell(1).setCellValue(w.getUserType());
			r.createCell(2).setCellValue(w.getUserCode());
			r.createCell(3).setCellValue(w.getUserFor());
			r.createCell(4).setCellValue(w.getUserEmail());
			r.createCell(5).setCellValue(w.getUserContact());
			r.createCell(6).setCellValue(w.getUserIdType());
			r.createCell(7).setCellValue(w.getIfOther());
			r.createCell(8).setCellValue(w.getIdNo());
			
				
			
			
			
		}
		}
		
	

	private void setBook(Sheet s) {
		
		Row r = s.createRow(0);
		
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("TYPE");
		r.createCell(2).setCellValue("CODE");
		r.createCell(3).setCellValue("UFOR");
		r.createCell(4).setCellValue("UMAIL");
		r.createCell(5).setCellValue("UCONTACT");
		r.createCell(6).setCellValue("IDTYPE");
		r.createCell(7).setCellValue("IFOTHER");
		r.createCell(8).setCellValue("IDNUMBER");
		
		
		
	}

}
