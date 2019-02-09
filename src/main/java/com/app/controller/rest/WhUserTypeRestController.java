package com.app.controller.rest;

import java.util.List;

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

import com.app.model.ShipmentType;
import com.app.model.Uom;
import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;



@RestController
@RequestMapping("/wst/rest")
public class WhUserTypeRestController {
	
	@Autowired
	private IWhUserTypeService service;
	
	@GetMapping("/all")
	public ResponseEntity<?> getData(){
		ResponseEntity<?> response= null;
		List<WhUserType> whs = service.getAllWhUserTypes();
		
		if(whs!=null && !whs.isEmpty()) {
			
			response= new ResponseEntity<List<WhUserType>>(whs,HttpStatus.OK);
		}else {
			
			response= new ResponseEntity<String>("Data not found",HttpStatus.OK);
		}
		
		return response;
		
	}
	
	 @GetMapping("/get/{id}")
	  public ResponseEntity<?> getOneRow(@PathVariable Integer id){
		  
		  ResponseEntity<?> res = null;
		 WhUserType wsth= service.getWhUserTypeById(id);
		   if(wsth!=null ) {
			   
			   res= new ResponseEntity<WhUserType>(wsth,HttpStatus.OK);
		   }else {
			   res = new ResponseEntity<String>("DATA NOT FOUND",HttpStatus.BAD_REQUEST);
		   }
		  
		return res;
		  
		
	  }
	  @DeleteMapping("/delete/{id}")
	  public ResponseEntity<String> delete(@PathVariable Integer id){
		  
		  ResponseEntity<String> res= null;
		  try {
			service.deleteWhUserType(id);
			res= new ResponseEntity<String>("WhUserType id'"+id+"' deleted",HttpStatus.OK);
		} catch (Exception e) {
			res= new ResponseEntity<String>("WhUserType id '"+id+"' not found",HttpStatus.BAD_REQUEST);
		}
		  
		return res;
		  
		  
		  
	  }

	  //save the data
	  @PostMapping("/save")
	  public ResponseEntity<String> saveData(@RequestBody WhUserType ws){
		  
	   int id  =service.saveWhUserType(ws);
	   
	  ResponseEntity<String> res= new ResponseEntity<String>("WhUserType saved with id '"+id+"' ",HttpStatus.OK);
		  
		  
		  return res;
	  }
	  
	//update the data
	  @PutMapping("/update")
	  public ResponseEntity<String> update(@RequestBody WhUserType ws){
		  
		  ResponseEntity<String> res= null;
		  try {
			service.updateWhUserType(ws);;
			res=new ResponseEntity<String>("WhUserType '"+ws.getId()+"'",HttpStatus.OK);
		} catch (Exception e) {
			res= new ResponseEntity<String>("WhUserType id not found",HttpStatus.BAD_REQUEST);
			
		}
		  
		  
		  return res;
	  }

}
