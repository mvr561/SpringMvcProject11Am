package com.app.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;
import com.app.util.OrderMethodUtil;
import com.app.util.ShipmentModeUtil;
import com.app.validation.OrderMethodValidator;
import com.app.validation.ShipmentTypeValidator;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {

	@Autowired
	private IShipmentTypeService service;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private  ShipmentModeUtil util;
	
	@Autowired
	private ShipmentTypeValidator validator;
	

	// show register page
	@RequestMapping("/register")
	public String showPage(ModelMap m) {
		
		
		//create form backing object
		m.addAttribute("shipmentType",new ShipmentType());

		return "ShipmentTypeRegister";
	}

	//inserting data
	@RequestMapping(value = "/insert", method ={RequestMethod.POST})
	public String Save(@ModelAttribute ShipmentType shipmentType,Errors errors, ModelMap m) {
		validator.validate(shipmentType, errors);
		
		if(errors.hasErrors()) {
			
			m.addAttribute("message", "please check all errors");
		}else {
		
		int id = service.saveShipmentType(shipmentType);
		String msg = "saved with id" +id;
		m.addAttribute("message", msg);
		m.addAttribute("shipmentType", new ShipmentType());
		}
        return "ShipmentTypeRegister";

	}
	//view all records
	@RequestMapping("/all")
	public String viewAll(ModelMap m) {
	List<ShipmentType> obs=service.getAllShipments();
	m.addAttribute("list",obs);
	
	return "ShipmentTypeData";
	}

	
	//delete record by id
	@RequestMapping("/delete")
	public String delete(@RequestParam Integer sid,ModelMap m) {
	//deleting record
	service.deleteShipmentType(sid);
	
	
	//get all record
	List<ShipmentType> obs=service.getAllShipments();
	m.addAttribute("list",obs);
	
	
	
	//add message to display
	m.addAttribute("message","record deleted:"+sid);
	return "ShipmentTypeData";
	}
	
	//view one row/object
	@RequestMapping("/viewone")
	public String getOne(@RequestParam Integer sid,ModelMap m)
	{
		ShipmentType obs=service.getShipmentTypeById(sid);
		m.addAttribute("st",obs);
		return "ShipmentTypeView";

	}
	//6 view edit page with data from db
	
	@RequestMapping("/editone")
	public String showEdit(@RequestParam Integer sid,ModelMap m
			) {
		
		//call service method 
		ShipmentType st=service.getShipmentTypeById(sid);
		
		//send to UI
		m.addAttribute("s",st);
		
		return  "ShipmentTypeEdit";
		
		
	
		
	}
	
	//7 Do update data
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String Update(@ModelAttribute ShipmentType s,ModelMap m) {
		//call service update
		service.updateShipmentType(s);
		
		//sucess message
		m.addAttribute("message","Shipment Updated");
		
		//get new data
		m.addAttribute("list",service.getAllShipments());
		
		return "ShipmentTypeData";
		
	
	}
	
	//8.get all ExcelExportSheet
	
	@RequestMapping("/excelexp")
	
	public ModelAndView doExcelExport() {
		
		//reading data from DB
		List<ShipmentType> list=service.getAllShipments();
		
		//view,key,val
		return new ModelAndView(new ShipmentTypeExcelView(),"list",list);

	}
	
	
	//get one row excel sheet
	@RequestMapping("/viewoneexel")
	
public ModelAndView doOneExcelExport(@RequestParam Integer sid) {
		
		//reading data from DB
		ShipmentType st= service.getShipmentTypeById(sid);
		
		//view,key,val
		return new ModelAndView(new ShipmentTypeExcelView(),"list",Arrays.asList(st));
		
	
	}
	
	//10.pdf export to all
	@RequestMapping("/pdfExp")
	public ModelAndView showPage() {
		
		
	List<ShipmentType> lst=	service.getAllShipments();
	
  return new ModelAndView(new ShipmentTypePdfView(),"list",lst);
		
		
		
		
		
	}
	//pdf export only one row
	
	@RequestMapping("/pdfOneExp")
	public ModelAndView showOnePage(@RequestParam Integer sid) {
		
		ShipmentType s= service.getShipmentTypeById(sid);

	
  return new ModelAndView(new ShipmentTypePdfView(),"list",Arrays.asList(s));
		
		
		
		
		
	}
	
	//pie chart&bar chart
	  @RequestMapping("/report")
	  public String doPie() {
		  
		  String path=context.getRealPath("/");
		  
		  List<Object[]> data= service.getShipmentModeCount();
		  //pie chart
		  util.generatePie(path,data);
		  //barchart
		  util.generateBar(path, data);
		  
		return "ShipmentModeReports";
		  
		  
		  
	  }
	 
	  
	
	}
	

		
		
		
		
		
		
		

	