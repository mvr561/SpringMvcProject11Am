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

import com.app.model.Uom;
import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
import com.app.util.ShipmentModeUtil;
import com.app.util.WhUserTypeUtil;
import com.app.validation.WhUserTypeValidator;

@Controller
@RequestMapping("/wst")
public class WhUserTypeController {
	
	@Autowired
	private IWhUserTypeService service;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private  WhUserTypeUtil util;
	
	@Autowired  
	private WhUserTypeValidator validator;
	 
	@RequestMapping("/register")
	public String showPage(ModelMap m) {
		
		m.addAttribute("whUserType",new WhUserType());
		
		return "WhUserTypeRegister";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String savePage(@ModelAttribute WhUserType whUserType,Errors errors,ModelMap m) {
		validator.validate(whUserType, errors);
		
		if(errors.hasErrors()) {
			
			m.addAttribute("message","plaese check all credentials");
		}else {
		
		int id=service.saveWhUserType(whUserType);
		
		String msg="inserted successfully wirh id "+id;
		
		m.addAttribute("ws",new WhUserType());
		m.addAttribute("message",msg);
		}
		return "WhUserTypeRegister";
	
	}
	
	//view all records
	@RequestMapping("/all")
	public String viewPage(ModelMap m) {
		
		List<WhUserType> obs=service.getAllWhUserTypes();
		
		m.addAttribute("list",obs);
		
		
		return "WhUserTypeData";
	
	}
	
	//delete record by id
	@RequestMapping("/delete")
   public String delete(@RequestParam Integer id,ModelMap m) {
	
		//delete record by id
		
		service.deleteWhUserType(id);
		
		m.addAttribute("message","deleted");
		
		//get all records after deleting
        List<WhUserType> obs=service.getAllWhUserTypes();
		
		m.addAttribute("list",obs);
		
		
		return "WhUserTypeData";

	}
	
	//view page by id
	@RequestMapping("/view")
	public String viewSingle(@RequestParam Integer id,ModelMap m) {
		
		WhUserType wst=service.getWhUserTypeById(id);
		
		m.addAttribute("w",wst);
	
		
		return "WhUserTypeView";
	
	}
	//editpage and view
	@RequestMapping("/edit")
	public String viewEdit(@RequestParam Integer id,ModelMap m) {
		
		WhUserType wst=service.getWhUserTypeById(id);
		
		m.addAttribute("wstr",wst);
		return "WhUserTypeEdit";
		
	}
	///edit and update
		@RequestMapping(value="/update",method=RequestMethod.POST)
		public String update(@ModelAttribute WhUserType ws, ModelMap m) {
			
			service.updateWhUserType(ws);
			
			m.addAttribute("message","updated");
			m.addAttribute("list", service.getAllWhUserTypes());
			
			
			return "WhUserTypeData";
			
			
			
		}
		//excelexport all
		
		@RequestMapping("/excelexp")
		public ModelAndView doExcelExport() {
			
			List<WhUserType> obs=service.getAllWhUserTypes();
			
			//here whuserExcelview overrids view so don't need to write setviewname
			
			
			return new ModelAndView(new WhUserTypeExcelView(),"ravi",obs);
			
			
			
		}
		
		
		
		//excelexport one
		
				@RequestMapping("/viewoneexcel")
				public ModelAndView doOneExcelExport(@RequestParam Integer id) {
					
					WhUserType w= service.getWhUserTypeById(id);
					
					//here whuserExcelview overrids view so don't need to write setviewname
					
					
					return new ModelAndView(new WhUserTypeExcelView(),"ravi",Arrays.asList(w));
					
					
					
				}
				
				
				
				//10.pdf export to all
				@RequestMapping("/pdfExp")
				public ModelAndView showPage() {
					
					
				List<WhUserType> lst=	service.getAllWhUserTypes();
				
			  return new ModelAndView(new WhUserTypePdfView(),"list",lst);
					
					
					
					
					
				}
				//pdf export only one row
				
				@RequestMapping("/pdfOneExp")
				public ModelAndView showOnePage(@RequestParam Integer id) {
					
					WhUserType ws= service.getWhUserTypeById(id);

				
			  return new ModelAndView(new WhUserTypePdfView(),"list",Arrays.asList(ws));
					
					
					
					
					
				}
				
				
				//pie chart
				  @RequestMapping("/report")
				  public String doPie() {
					  
					  String path=context.getRealPath("/");
					  
					  List<Object[]> data= service.getUserTypeCount();
					  
					  util.generatePie(path,data);
					  util.generateBar(path, data);
					return "WhUserTypeReports";
					  
					  
					  
				  }
						
		
	}
	
	





