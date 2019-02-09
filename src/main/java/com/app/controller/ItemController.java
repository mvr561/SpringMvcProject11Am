package com.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Item;
import com.app.model.OrderMethod;
import com.app.service.IItemService;
import com.app.validation.ItemValidator;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private IItemService service;
	
	@Autowired
	private ItemValidator validator;
	
	//1.to show the register page
	@RequestMapping("/register")
	public String showRegister(ModelMap map) {
		
		map.addAttribute("item",new Item());
		
		
		
		return "ItemRegister";
		
	}
	//2.save data
	@RequestMapping(value = "/insert", method ={RequestMethod.POST})
	public String saveData(@ModelAttribute Item item,Errors errors,ModelMap map) {
		
		validator.validate(item, errors);
		
		if(errors.hasErrors()) {
			
			map.addAttribute("msg","please check all errors");
			
		}else {
		
		int id=service.saveItem(item);
		
		String msg="saved with id"+id;
		
		map.addAttribute("msg",msg);
		
		map.addAttribute("item",new Item());
		}
		return "ItemRegister";
		
		
	}
	//3.view all records
	
	@RequestMapping("/all")
	public String viewData(ModelMap map) {
		
	List<Item>	list=service.getAllItems();
		map.addAttribute("list",list);
		
		return "ItemData";
	
	}
	//4.delete record by id
	
	//delete record by id
		@RequestMapping("/delete")
		public String delete(@RequestParam Integer id,ModelMap m) {
			//deleting record
			service.deleteItem(id);;


			//get all record
			List<Item> obs=service.getAllItems();
			m.addAttribute("list",obs);



			//add message to display
			m.addAttribute("message","record deleted:"+id);
			return "ItemData";
		}


	
		//view one row/object
		@RequestMapping("/viewone")
		public String getOne(@RequestParam Integer id,ModelMap m)
		{
			Item obs=service.saveItemById(id);
			m.addAttribute("st",obs);
			return "ItemView";


		}
	
	
		//6 view edit page with data from db

		@RequestMapping("/editone")
		public String showEdit(@RequestParam Integer id,ModelMap m
				) {

			//call service method 
			Item it=service.saveItemById(id);

			//send to UI
			m.addAttribute("s",it);

			return  "ItemEdit";




		}

		//7 Do update data
		@RequestMapping(value="/update",method=RequestMethod.POST)
		public String Update(@ModelAttribute Item item,ModelMap m) {
			//call service update
			service.updateItem(item);;

			//sucess message
			m.addAttribute("message","Item Updated with id");

			//get new data
			m.addAttribute("list",service.getAllItems());

			return "ItemData";

		

		}
	
	
	
		//excelexport all
		@RequestMapping("/excelexp")
		public ModelAndView doExcelExport() {
			//get all records from db	
			List<Item> list= service.getAllItems();

			return new ModelAndView(new ItemExcelView(),"list",list);



		}

		//export one excel	
		@RequestMapping("/viewoneexcel")
		public ModelAndView doOneExcelExport(@RequestParam Integer id) {
			//get all records from db	
			Item it=service.saveItemById(id);

			return new ModelAndView(new ItemExcelView(),"list",Arrays.asList(it));



		}
		
		//10.pdf export to all
				@RequestMapping("/pdfExp")
				public ModelAndView showPage() {
					
					
				List<Item> lst=	service.getAllItems();
				
			  return new ModelAndView(new ItemPdfView(),"list",lst);
					
					
					
					
					
				}
				//pdf export only one row
				
				@RequestMapping("/pdfoneexport")
				public ModelAndView showOnePage(@RequestParam Integer id) {
					
					Item it= service.saveItemById(id);

				
			  return new ModelAndView(new ItemPdfView(),"list",Arrays.asList(it));
					
					
			
		
		
				}
		
		
				}
	
	
	
	
	
	
	



