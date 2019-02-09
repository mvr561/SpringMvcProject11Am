package com.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Uom;
import com.app.model.User;
import com.app.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService service;

	@RequestMapping("/register")
	public String showPage(ModelMap m) {
		m.addAttribute("msg", new User());
		return "UserRegister";
	}

	@RequestMapping(value = "/insert",method=RequestMethod.POST)
	public String savePage(@ModelAttribute User us, ModelMap m) {
		int id = service.saveUser(us);
		String message = "insertedwith id" + id;
		m.addAttribute("msgs", message);
		m.addAttribute("msg", new User());
		return "UserRegister";

	}
	@RequestMapping("/all")
	public String viewTable(ModelMap m) {
	List<User> lst =service.getAllUsers();
		
		m.addAttribute("list",lst);
		
		
		return "UserData";
		
		
	}
	@RequestMapping("/delete")
	public String deleteRow(@RequestParam Integer uid,ModelMap m) {
		
		service.deleteUser(uid);
		String msg="row deleted " +uid;
		m.addAttribute("message",msg);
		
List<User> lst =service.getAllUsers();
		
		m.addAttribute("list",lst);
		
		
		return "UserData";
		
		
		
	}
	//view
	@RequestMapping("/viewone")
	public String viewPage(@RequestParam Integer uid,ModelMap m){
		
	  User u=service.getUserById(uid);
	  m.addAttribute("st",u);
		
		return "UserView";
		
		
	}
  //edit
	@RequestMapping("/editone")
	public String editPage(@RequestParam Integer uid,ModelMap m) {
		
    User u=service.getUserById(uid);
    
    m.addAttribute("st", u);
		
		return "UserEdit";
		
		
		
	}
	//update
	@RequestMapping("/update")
	public String doUpdate(@ModelAttribute User us,ModelMap m) {
		
		service.updateUser(us);
		
       List<User> lst =service.getAllUsers();
		
		m.addAttribute("list",lst);
		
		
		return "UserData";
		
	
	}
	//excelExport All
	@RequestMapping("/excelexp")
	public ModelAndView doExcelExport() {
		
		List<User> lt=service.getAllUsers();
		
	return new ModelAndView(new UserExcelView(),"list",lt);
		
		
		
		
	}
	//view one excelexport
	@RequestMapping("/viewoneexcel")
	public ModelAndView viewOneExcel(@RequestParam Integer uid) {
		
		User u = service.getUserById(uid);
		
		 return new ModelAndView(new UserExcelView(),"list",Arrays.asList(u));
		
		
		
	}
	
	//view pdf Export
	@RequestMapping("/pdfExp")
	public ModelAndView doPdfExport() {
		

		List<User> lt=service.getAllUsers();
		
	return new ModelAndView(new UserPdfView(),"list",lt);
		
	}

	@RequestMapping("/pdfOneExp")
	public ModelAndView showOnePage(@RequestParam Integer uid) {
		
		User u= service.getUserById(uid);

	
  return new ModelAndView(new UserPdfView(),"list",Arrays.asList(u));
	}
}
