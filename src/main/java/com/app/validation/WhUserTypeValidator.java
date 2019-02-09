package com.app.validation;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.WhUserType;


@Component
public class WhUserTypeValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return WhUserType.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		WhUserType w=(WhUserType)target;
		
       if(StringUtils.isEmpty(w.getUserType())) {
			
			errors.rejectValue("userType", null, "please select any one option!!");
		
		} 
		
   	if(!StringUtils.hasText(w.getUserCode())) {
		
		errors.rejectValue("userCode", null, "please enter user code");
	}else if (Pattern.matches("[A-Z]",w.getUserCode())) {
		
		errors.rejectValue("userCode", null, "please enter UpperCase atleast 4 letters");
	}
	
   	if(StringUtils.isEmpty(w.getUserFor())) {
		
		errors.rejectValue("userFor", null, "please select any one opyion");
		
	}
 	if(!StringUtils.hasText(w.getUserEmail())) {
		
		errors.rejectValue("userEmail", null, "please enter user code");
	}else if (Pattern.matches("[A-Z]",w.getUserEmail())) {
		
		errors.rejectValue("userEmail", null, "please enter UpperCase atleast 4 letters");
	}
 	
 	if(!StringUtils.hasText(w.getUserContact())) {
		
		errors.rejectValue("userContact", null, "please enter user code");
	}else if (Pattern.matches("[A-Z]",w.getUserContact())) {
		
		errors.rejectValue("userContact", null, "please enter UpperCase atleast 4 letters");
	}
		
		
	if(StringUtils.isEmpty(w.getIfOther())) {
		
		errors.rejectValue("ifOther", null, "please select any one opyion");
		
	}
	
	if(w.getIdNo()== 0) {
	errors.rejectValue("idNo", null, "please enter any number not 0");
	}

}
	
}
