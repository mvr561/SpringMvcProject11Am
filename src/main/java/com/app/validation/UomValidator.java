package com.app.validation;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Uom;


@Component
public class UomValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Uom.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Uom um= (Uom)target;
		
		
		
        if(StringUtils.isEmpty(um.getUomType())) {
			
			errors.rejectValue("uomType", null, "please select any one opyion");
			
		}
		
     if(!StringUtils.hasText(um.getUomModel())) {
			
			errors.rejectValue("uomModel", null, "please enter order code");
		}else if (Pattern.matches("[A-Z]",um.getUomModel())) {
			
			errors.rejectValue("uomModel", null, "please enter UpperCase atleast 4 letters");
		}
		
		
     if(!StringUtils.hasText(um.getUomDsc())) {
			errors.rejectValue("uomDsc",null,"please enter any text");
		}else if(um.getUomDsc().length()>10 && um.getUomDsc().length()<=15) {
			errors.rejectValue("uomDsc",null,"please enter text 10 to 15 letters");
		}
		
		
	}

}
