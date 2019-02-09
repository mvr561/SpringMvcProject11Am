package com.app.validation;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.ShipmentType;

@Component
public class ShipmentTypeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return ShipmentType.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ShipmentType st=(ShipmentType)target;
		
		
		
		//execution type multi dropdown checks empty
				if(StringUtils.isEmpty(st.getShipmentMode())) {
					
					errors.rejectValue("shipmentMode", null, "please select any one option");
					
	          }
				if(!StringUtils.hasText(st.getShipmentCode())) {
					
					errors.rejectValue("shipmentCode", null, "please enter order code");
				}else if (Pattern.matches("[A-Z]",st.getShipmentCode())) {
					
					errors.rejectValue("shipmentCode", null, "please enter UpperCase atleast 4 letters");
				}
				
				if(StringUtils.isEmpty(st.getEnableshipment())) {
					
					errors.rejectValue("enableshipment", null, "please select any one opyion");
			
	
				}
				
				if(StringUtils.isEmpty(st.getShipmentGrade())) {
					
					errors.rejectValue("shipmentGrade", null, "please select any one option!!");
				
				}
				

				if(!StringUtils.hasText(st.getShipmentDesc())) {
					errors.rejectValue("shipmentDesc",null,"please enter any text");
				}else if(st.getShipmentDesc().length()>10 && st.getShipmentDesc().length()<=15) {
					errors.rejectValue("shipmentDesc",null,"please enter text 10 to 100 letters");
				}
				
	}
	
	
	
	}
