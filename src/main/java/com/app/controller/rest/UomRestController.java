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
import com.app.service.IUomService;

@RestController
@RequestMapping("/uom/rest")
public class UomRestController {
	
	@Autowired
	private IUomService service;
	
	@GetMapping("/all")
	public ResponseEntity<?> getData(){
		ResponseEntity<?> response= null;
		List<Uom> uoms = service.getAllUoms();
		
		if(uoms!=null && !uoms.isEmpty()) {
			
			response= new ResponseEntity<List<Uom>>(uoms,HttpStatus.OK);
		}else {
			
			response= new ResponseEntity<String>("Data not found",HttpStatus.OK);
		}
		
		return response;
		
	}
	 @GetMapping("/get/{id}")
	  public ResponseEntity<?> getOneRow(@PathVariable Integer id){
		  
		  ResponseEntity<?> res = null;
		  Uom um= service.getUomById(id);
		   if(um!=null ) {
			   
			   res= new ResponseEntity<Uom>(um,HttpStatus.OK);
		   }else {
			   res = new ResponseEntity<String>("DATA NOT FOUND",HttpStatus.BAD_REQUEST);
		   }
		  
		return res;
		  
		
	  }
	  @DeleteMapping("/delete/{id}")
	  public ResponseEntity<String> delete(@PathVariable Integer id){
		  
		  ResponseEntity<String> res= null;
		  try {
			service.deleteUom(id);
			res= new ResponseEntity<String>("UomType id'"+id+"' deleted",HttpStatus.OK);
		} catch (Exception e) {
			res= new ResponseEntity<String>("Uom id '"+id+"' not found",HttpStatus.BAD_REQUEST);
		}
		  
		return res;
		  
		  
		  
	  }
	  
	  
	  //save the data
	  @PostMapping("/save")
	  public ResponseEntity<String> saveData(@RequestBody Uom u){
		  
	   int id  =service.saveUom(u);
	   
	  ResponseEntity<String> res= new ResponseEntity<String>("Uom saved with id '"+id+"' ",HttpStatus.OK);
		  
		  
		  return res;
	  }
	  
	//update the data
	  @PutMapping("/update")
	  public ResponseEntity<String> update(@RequestBody Uom u){
		  
		  ResponseEntity<String> res= null;
		  try {
			service.updateUom(u);
			res=new ResponseEntity<String>("Uom Updated '"+u.getUomId()+"'",HttpStatus.OK);
		} catch (Exception e) {
			res= new ResponseEntity<String>("Uom id not found",HttpStatus.BAD_REQUEST);
			
		}
		  
		  
		  return res;
	  }

}
