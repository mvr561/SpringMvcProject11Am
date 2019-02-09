package com.app.validation;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.OrderMethod;
@Component
public class OrderMethodValidator implements Validator{

	
	public boolean supports(Class<?> clazz) {
		
		return OrderMethod.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
	  //down cast from Object to model class
		OrderMethod odm=(OrderMethod)target;
		
		//ordermode radio check is empty or not
		if(StringUtils.isEmpty(odm.getOrderMode())) {
			
			errors.rejectValue("orderMode", null, "please select any one option!!");
		
		}
		//ordercode is Text so we can check as a text
		
		if(!StringUtils.hasText(odm.getOrderCode())) {
			
			errors.rejectValue("orderCode", null, "please enter order code");
		}else if (Pattern.matches("[A-Z]",odm.getOrderCode())) {
			
			errors.rejectValue("orderCode", null, "please enter UpperCase atleast 4 letters");
		}
		
		//execution type multi dropdown checks empty
		if(StringUtils.isEmpty(odm.getExeType())) {
			
			errors.rejectValue("exeType", null, "please select any one opyion");
			
		}
		//OrderAccept
		if(odm.getOrderAccept()==null ||odm.getOrderAccept().isEmpty()) {
			
			errors.rejectValue("orderAccept", null, "please selct atlaset one option");
		}
		//order discription
		
		if(!StringUtils.hasText(odm.getOrderDsc())) {
			errors.rejectValue("orderDsc",null,"please enter any text");
		}else if(odm.getOrderDsc().length()>10 && odm.getOrderDsc().length()<=15) {
			errors.rejectValue("orderDsc",null,"please enter text 10 to 100 letters");
		}
		
	}

}
