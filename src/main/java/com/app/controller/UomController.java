package com.app.controller;

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
import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.util.OrderMethodUtil;
import com.app.util.UomUtil;
import com.app.validation.UomValidator;

@Controller
@RequestMapping("/uom")
public class UomController {
	@Autowired
	private IUomService service;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private UomUtil util;
	
	@Autowired
	private UomValidator validator;
	
	// show register page
		@RequestMapping("/register")
		public String showPage(ModelMap m) {
			//create form backing object
			m.addAttribute("uom", new Uom());

			return "UomRegister";
		}
		
		//inserting data
		@RequestMapping(value ="/insert", method ={RequestMethod.POST})
		public String Save(@ModelAttribute Uom uom,Errors errors, ModelMap m) {
    validator.validate(uom, errors);
    
    
    if(errors.hasErrors()) {
    	m.addAttribute("message","please check all ctredentials");
    }else {
	      //call servicelayer save method
			int i = service.saveUom(uom);
			String msg = "saved with id" +i;
			m.addAttribute("message",msg);
			//for clearing object 
			m.addAttribute("s", new Uom());
    }
	        return "UomRegister";


}
		//view all records
		@RequestMapping("/all")
		public String viewAll(ModelMap m) {
		List<Uom> obs=service.getAllUoms();
		m.addAttribute("list",obs);
		return "UomData";
		}
		
		
		//delete record by id
		@RequestMapping("/delete")
		public String delete(@RequestParam Integer uid,ModelMap m) {
		//deleting record
		service.deleteUom(uid);
		
		
		//get all record
		List<Uom> obs=service.getAllUoms();
		m.addAttribute("list",obs);
		
		
		
		//add message to display
		m.addAttribute("message","record deleted:"+uid);
		return "UomData";
		}

		
		//view one row/object
		@RequestMapping("/viewone")
		public String getOne(@RequestParam Integer uid,ModelMap m)
		{
			Uom obs=service.getUomById(uid);
			m.addAttribute("st",obs);
			return "UomView";
			
		
		
}
		
		
		//6 view edit page with data from db
		
		@RequestMapping("/editone")
		public String showEdit(@RequestParam Integer uid,ModelMap m
				) {
			
			//call service method 
		Uom st=service.getUomById(uid);
			
			//send to UI
			m.addAttribute("u",st);
			
			return  "UomEdit";
			
			
		
			
		}
		
		//7 Do update data
		@RequestMapping(value="/update",method=RequestMethod.POST)
		public String Update(@ModelAttribute Uom u,ModelMap m) {
			//call service update
			service.updateUom(u);
			
			//Success message
			m.addAttribute("message","Uom  Updated");
			
			//get new data
			m.addAttribute("list",service.getAllUoms());
			
			return "UomData";
			
			
			
		}
		
//8.ExcelSxport all
		@RequestMapping("/excelexp")
		public ModelAndView doExcelExport() {
			
			//read from db
			List<Uom> list=service.getAllUoms();
			
			//view,key,value
			return new ModelAndView(new UomExcelView(),"list",list);
		
}
		
	//9 excel Export one	
		
		@RequestMapping("/viewoneexcel")
		public ModelAndView doOneExcelExport(@RequestParam Integer uid) {
			
			//read from db
			Uom u=service.getUomById(uid);
			
			//view,key,value
			return new ModelAndView(new UomExcelView(),"list",Arrays.asList(u));
		
}
	
		//10.pdf export to all
		@RequestMapping("/pdfExp")
		public ModelAndView showPage() {
			
			
		List<Uom> lst=	service.getAllUoms();
		
	  return new ModelAndView(new UomPdfView(),"list",lst);
			
			
			
			
			
		}
		//pdf export only one row
		
		@RequestMapping("/pdfOneExp")
		public ModelAndView showOnePage(@RequestParam Integer uid) {
			
			Uom u= service.getUomById(uid);

		
	  return new ModelAndView(new UomPdfView(),"list",Arrays.asList(u));
			
			
			
			
			
		}
		
		//pie chart
		  @RequestMapping("/report")
		  public String doPie() {
			  
			  String path=context.getRealPath("/");
			  
			  List<Object[]> data= service.getUomTypeCount();
			  
			  util.generatePie(path,data);
			  util.generateBar(path, data);
			return "UomReports";
			  
		
		
}
}
