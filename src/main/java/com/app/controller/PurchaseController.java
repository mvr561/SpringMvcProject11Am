package com.app.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Purchase;
import com.app.service.IPurchaseService;
import com.app.validation.PurchaseValidator;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

	@Autowired
	private IPurchaseService service;
	@Autowired
	private PurchaseValidator validator;

	@RequestMapping("/register")
	public String showRegister(ModelMap map) {
		map.addAttribute("purchase", new Purchase());
		return "PurchaseRegister";
	}

	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String savePurchase(@ModelAttribute Purchase purchase,Errors errors,ModelMap map) {

     validator.validate(purchase, errors);


		if (errors.hasErrors()) {
			map.addAttribute("message", "please check all fields !!");
		} else {
			map.addAttribute("message", "Purchase is saved with Id :"+service.savePurchase(purchase));
			map.addAttribute("purchase", new Purchase());
		}
		return "PurchaseRegister";
	}

	@RequestMapping("/viewAll")
	public String viewAll(ModelMap map) {

		map.addAttribute("purchase", service.getAllPurchases());
		return "PurchaseData";
	}

	@RequestMapping("/viewOne")
	public String viewOne(@RequestParam Integer orderId,ModelMap map) {

		map.addAttribute("purchase", service.getPurchaseById(orderId));
		return "PurchaseView";
	}

	@RequestMapping("/delete")
	public String deletePurchase(@RequestParam Integer orderId,ModelMap map) {

		service.deletePurchase(orderId);
		map.addAttribute("message", "Purchase deleted successfully with id :"+orderId+" !!");
		map.addAttribute("purchase", service.getAllPurchases());
		return "PurchaseData";
	}

	@RequestMapping("/edit")
	public String editOne(@RequestParam Integer orderId,ModelMap map) {

		map.addAttribute("purchase", service.getPurchaseById(orderId));
		return "PurchaseEdit";
	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updatePurchase(@ModelAttribute Purchase purchase,Errors errors,ModelMap map) {

		String page=null;

		validator.validate(purchase, errors);

		if (errors.hasErrors()) {
			map.addAttribute("message", "please check all fields !");
			page="PurchaseEdit";
		} else {
			service.updatePurchase(purchase);
			map.addAttribute("purchase", service.getAllPurchases());
			map.addAttribute("message", "Purchase with id "+purchase.getOrderId()+"saved successfully !");
			page="PurchaseData";
		}
		return page;
	}

	@RequestMapping("/excelExport")
	public ModelAndView excelExport(@RequestParam(required=false,defaultValue="0") Integer orderId,ModelMap map) {
		ModelAndView mv=null;
		if (orderId!=0) {
			mv=new ModelAndView(new PurchaseExcelView(), "purchase", Arrays.asList(service.getPurchaseById(orderId)));
		} else {
			mv=new ModelAndView(new PurchaseExcelView(), "purchase", service.getAllPurchases());
		}
		return mv;
	}
	@RequestMapping("/pdfExport")
	public ModelAndView pdfExport(@RequestParam(required=false,defaultValue="0") Integer orderId,ModelMap map) {
		ModelAndView mv=null;
		if (orderId!=0) {
			mv=new ModelAndView(new PurchasePdfView(), "purchase", Arrays.asList(service.getPurchaseById(orderId)));
		} else {
			mv=new ModelAndView(new PurchasePdfView(), "purchase", service.getAllPurchases());
		}
		return mv;
	}
}
