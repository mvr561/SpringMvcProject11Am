package com.app.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.websocket.server.ServerContainer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.OrderMethod;
import com.app.model.ShipmentType;
import com.app.model.Uom;
import com.app.service.IOrderMethodService;
import com.app.util.OrderMethodUtil;
import com.app.validation.OrderMethodValidator;
import com.sun.xml.internal.ws.api.policy.PolicyResolver.ServerContext;

@Controller
@RequestMapping("/order")
public class OrderMethodController {
	@Autowired
	private IOrderMethodService service;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private OrderMethodUtil util;
	
	@Autowired
	private OrderMethodValidator validator;
	
	


	// show register page
	@RequestMapping("/register")
	public String showPage(ModelMap m) {

		//creating object for biderectional
		m.addAttribute("orderMethod",new OrderMethod());

		return "OrderMethodRegister";

	}
	//inserting data
	@RequestMapping(value ="/insert", method =RequestMethod.POST)
	public String Save(@ModelAttribute OrderMethod orderMethod,Errors errors, ModelMap m) {
        validator.validate(orderMethod, errors);
		//call servicelayer save method
		if(errors.hasErrors()) {
			m.addAttribute("message","please check all errors");
			
		}else {
		int i = service.saveOrderMethod(orderMethod);
		String msg = "saved with id" +i;
		m.addAttribute("message",msg);
		// for cleaning of object afert inserting into db 
		m.addAttribute("orderMethod",new OrderMethod());
		}
		return "OrderMethodRegister";


	}
	//view all records
	@RequestMapping("/all")
	public String viewAll(ModelMap m) {
		List<OrderMethod> obs=service.getAllOrderMethods();
		m.addAttribute("list",obs);
		return "OrderMethodData";
	}


	//delete record by id
	@RequestMapping("/delete")
	public String delete(@RequestParam Integer id,ModelMap m) {
		//deleting record
		service.deleteOrderMethod(id);


		//get all record
		List<OrderMethod> obs=service.getAllOrderMethods();
		m.addAttribute("list",obs);



		//add message to display
		m.addAttribute("message","record deleted:"+id);
		return "OrderMethodData";
	}



	//view one row/object
	@RequestMapping("/viewone")
	public String getOne(@RequestParam Integer id,ModelMap m)
	{
		OrderMethod obs=service.getOrderMethodById(id);
		m.addAttribute("st",obs);
		return "OrderMethodView";




	}
	//6 view edit page with data from db

	@RequestMapping("/editone")
	public String showEdit(@RequestParam Integer id,ModelMap m
			) {

		//call service method 
		OrderMethod os=service.getOrderMethodById(id);

		//send to UI
		m.addAttribute("s",os);

		return  "OrderMethodEdit";




	}

	//7 Do update data
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String Update(@ModelAttribute OrderMethod om,ModelMap m) {
		//call service update
		service.updateOrderMethod(om);

		//sucess message
		m.addAttribute("message","ShipmentUpdated");

		//get new data
		m.addAttribute("list",service.getAllOrderMethods());

		return "OrderMethodData";



	}

	//excelexport all
	@RequestMapping("/excelexp")
	public ModelAndView doExcelExport() {
		//get all records from db	
		List<OrderMethod> list= service.getAllOrderMethods();

		return new ModelAndView(new OrderMethodExcelView(),"list",list);



	}

	//export one excel	
	@RequestMapping("/viewoneexcel")
	public ModelAndView doOneExcelExport(@RequestParam Integer id) {
		//get all records from db	
		OrderMethod os=service.getOrderMethodById(id);

		return new ModelAndView(new OrderMethodExcelView(),"list",Arrays.asList(os));



	}
	
	//10.pdf export to all
			@RequestMapping("/pdfExp")
			public ModelAndView showPage() {
				
				
			List<OrderMethod> lst=	service.getAllOrderMethods();
			
		  return new ModelAndView(new OrderMethodPdfView(),"list",lst);
				
				
				
				
				
			}
			//pdf export only one row
			
			@RequestMapping("/pdfoneexport")
			public ModelAndView showOnePage(@RequestParam Integer id) {
				
				OrderMethod om= service.getOrderMethodById(id);

			
		  return new ModelAndView(new OrderMethodPdfView(),"list",Arrays.asList(om));
				
				
		
			}
			
 //pie chart
  @RequestMapping("/report")
  public String doPie() {
	  
	  String path=context.getRealPath("/");
	  
	  List<Object[]> data= service.getOrderModeTypeCount();
	  //pie chart
	  util.generatePie(path,data);
	  //barchart
	  util.generateBar(path, data);
	return "OrderMethodReports";
	  
	  
	  
  }

}
