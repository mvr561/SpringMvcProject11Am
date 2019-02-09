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

import com.app.model.OrderMethod;
import com.app.model.ShipmentType;
import com.app.model.Uom;
import com.app.service.IShipmentTypeService;
import com.app.service.IUomService;

@RestController
@RequestMapping("/shs/rest")
public class ShipmentTypeRestController {
	
	@Autowired
	private IShipmentTypeService service;
	
	@GetMapping("/all")
	public ResponseEntity<?> getData(){
		ResponseEntity<?> response= null;
		List<ShipmentType> shs = service.getAllShipments();
		
		if(shs!=null && !shs.isEmpty()) {
			
			response= new ResponseEntity<List<ShipmentType>>(shs,HttpStatus.OK);
		}else {
			
			response= new ResponseEntity<String>("Data not found",HttpStatus.OK);
		}
		
		return response;
		
	}

	
	 @GetMapping("/get/{id}")
	  public ResponseEntity<?> getOneRow(@PathVariable Integer id){
		  
		  ResponseEntity<?> res = null;
		  ShipmentType sh= service.getShipmentTypeById(id);
		   if(sh!=null ) {
			   
			   res= new ResponseEntity<ShipmentType>(sh,HttpStatus.OK);
		   }else {
			   res = new ResponseEntity<String>("DATA NOT FOUND",HttpStatus.BAD_REQUEST);
		   }
		  
		return res;
		  
		
	  }
	  @DeleteMapping("/delete/{id}")
	  public ResponseEntity<String> delete(@PathVariable Integer id){
		  
		  ResponseEntity<String> res= null;
		  try {
			service.deleteShipmentType(id);;
			res= new ResponseEntity<String>("ShipmentType id'"+id+"' deleted",HttpStatus.OK);
		} catch (Exception e) {
			res= new ResponseEntity<String>("ShipmentType id '"+id+"' not found",HttpStatus.BAD_REQUEST);
		}
		  
		return res;
		 
	  }
	  
	  //save the data
	  @PostMapping("/save")
	  public ResponseEntity<String> saveData(@RequestBody ShipmentType sh){
		  
	   int id  =service.saveShipmentType(sh);
	   
	  ResponseEntity<String> res= new ResponseEntity<String>("Shipment saved with id '"+id+"' ",HttpStatus.OK);
		  
		  
		  return res;
	  }
	  
	//update the data
	  @PutMapping("/update")
	  public ResponseEntity<String> update(@RequestBody ShipmentType sh){
		  
		  ResponseEntity<String> res= null;
		  try {
			service.updateShipmentType(sh);;
			res=new ResponseEntity<String>("ShipmentType  Updated '"+sh.getId()+"'",HttpStatus.OK);
		} catch (Exception e) {
			res= new ResponseEntity<String>("ShipmentType  id not found",HttpStatus.BAD_REQUEST);
			
		}
		  
		  
		  return res;
	  }

}
