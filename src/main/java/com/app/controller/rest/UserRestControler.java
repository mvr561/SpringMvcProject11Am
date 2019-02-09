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
import com.app.model.User;
import com.app.service.IUserService;

@RestController
@RequestMapping("/user/rest")
public class UserRestControler {
	
	@Autowired
	private IUserService service;
	
	@GetMapping("/all")
	public ResponseEntity<?> getData(){
		ResponseEntity<?> response= null;
		List<User> userw = service.getAllUsers();
		
		if(userw!=null && !userw.isEmpty()) {
			
			response= new ResponseEntity<List<User>>(userw,HttpStatus.OK);
		}else {
			
			response= new ResponseEntity<String>("Data not found",HttpStatus.OK);
		}
		
		return response;
		
	}
	 @GetMapping("/get/{id}")
	  public ResponseEntity<?> getOneRow(@PathVariable Integer id){
		  
		  ResponseEntity<?> res = null;
		 User us= service.getUserById(id);
		   if(us!=null ) {
			   
			   res= new ResponseEntity<User>(us,HttpStatus.OK);
		   }else {
			   res = new ResponseEntity<String>("DATA NOT FOUND",HttpStatus.BAD_REQUEST);
		   }
		  
		return res;
		  
		
	  }
	  @DeleteMapping("/delete/{id}")
	  public ResponseEntity<String> delete(@PathVariable Integer id){
		  
		  ResponseEntity<String> res= null;
		  try {
			service.deleteUser(id);;
			res= new ResponseEntity<String>("User id'"+id+"' deleted",HttpStatus.OK);
		} catch (Exception e) {
			res= new ResponseEntity<String>("User id '"+id+"' not found",HttpStatus.BAD_REQUEST);
		}
		  
		return res;
	
	  }

	  
	  @PostMapping("/save")
	  public ResponseEntity<String> saveData(@RequestBody User u){
		  
	   int id  =service.saveUser(u);
	   
	  ResponseEntity<String> res= new ResponseEntity<String>("User saved with id '"+id+"' ",HttpStatus.OK);
		  
		  
		  return res;
	  }
	  
	//update the data
	  @PutMapping("/update")
	  public ResponseEntity<String> update(@RequestBody User u){
		  
		  ResponseEntity<String> res= null;
		  try {
			service.updateUser(u);;
			res=new ResponseEntity<String>("User  Updated '"+u.getUserId()+"'",HttpStatus.OK);
		} catch (Exception e) {
			res= new ResponseEntity<String>("User id not found",HttpStatus.BAD_REQUEST);
			
		}
		  
		  
		  return res;
	  }
}
