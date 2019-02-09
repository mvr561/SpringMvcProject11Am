package com.app.controller.rest;

import java.util.List;

import org.omg.CORBA.OMGVMCID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.OrderMethod;
import com.app.model.ShipmentType;
import com.app.model.Uom;
import com.app.service.IOrderMethodService;
import com.app.service.IUomService;
import com.app.util.OrderMethodUtil;

@RestController
@RequestMapping("/om/rest")
public class OrderMethodRestController {
	
	@Autowired
	private IOrderMethodService service;
	//get all data
	@GetMapping("/all")
	public ResponseEntity<?> getData(){
		ResponseEntity<?> response= null;
		List<OrderMethod> oms = service.getAllOrderMethods();
		
		if(oms!=null && !oms.isEmpty()) {
			
			response= new ResponseEntity<List<OrderMethod>>(oms,HttpStatus.OK);
		}else {
			
			response= new ResponseEntity<String>("Data not found",HttpStatus.OK);
		}
		
		return response;
		
	}

	//get data one row
	  @GetMapping("/get/{id}")
	  public ResponseEntity<?> getOneRow(@PathVariable Integer id){
		  
		  ResponseEntity<?> res = null;
		  OrderMethod om= service.getOrderMethodById(id);
		   if(om!=null ) {
			   
			   res= new ResponseEntity<OrderMethod>(om,HttpStatus.OK);
		   }else {
			   res = new ResponseEntity<String>("DATA NOT FOUND",HttpStatus.BAD_REQUEST);
		   }
		  
		return res;
		  
		
	  }
	  //delete one row
	  @DeleteMapping("/delete/{id}")
	  public ResponseEntity<String> delete(@PathVariable Integer id){
		  
		  ResponseEntity<String> res= null;
		  try {
			service.deleteOrderMethod(id);
			res= new ResponseEntity<String>("OrderMethod id'"+id+"' deleted",HttpStatus.OK);
		} catch (Exception e) {
			res= new ResponseEntity<String>("OrderMethod id '"+id+"' not found",HttpStatus.BAD_REQUEST);
		}
		  
		return res;
		
	  }
	  
	  @PostMapping("/save")
	  public ResponseEntity<String> saveData(@RequestBody OrderMethod od){
		  
	   int id  =service.saveOrderMethod(od);
	   
	  ResponseEntity<String> res= new ResponseEntity<String>("OrderMethod saved with id '"+id+"' ",HttpStatus.OK);
		  
		  
		  return res;
	  }
	  
	//update the data
	  @PutMapping("/update")
	  public ResponseEntity<String> update(@RequestBody OrderMethod orderMethod){
		  
		  ResponseEntity<String> res= null;
		  try {
			service.updateOrderMethod(orderMethod);
			res=new ResponseEntity<String>("OrderMethod  Updated '"+orderMethod.getId()+"'",HttpStatus.OK);
		} catch (Exception e) {
			res= new ResponseEntity<String>("OrderMethod id not found",HttpStatus.BAD_REQUEST);
			
		}
		  
		  
		  return res;
	  }
}
