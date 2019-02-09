package com.app.validation;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Item;

@Component
public class ItemValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Item.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Item it=(Item)target;
		
  if(!StringUtils.hasText(it.getItemCode())) {
			
			errors.rejectValue("itemCode", null, "please enter order code");
		}else if (!Pattern.matches("[A-Z]{4,6}",it.getItemCode())) {
			
			errors.rejectValue("itemCode", null, "please enter UpperCase atleast 4 letters");
		
		}
  
  
  if(StringUtils.isEmpty(it.getItemLength())) {
		errors.rejectValue("itemLength", null, "please enter any number not 0");
		}else if (it.getItemLength()<=0) {
			errors.rejectValue("itemLength", null, "please enter any number more than  0");
		}
  
  if(StringUtils.isEmpty(it.getItemWidth()) ){
		errors.rejectValue("itemWidth", null, "please enter any number not 0");
		}else if (it.getItemLength()<=0) {
			errors.rejectValue("itemWidth", null, "please enter any number more than  0");
		}
  
  if(StringUtils.isEmpty(it.getItemHeight())) {
		errors.rejectValue("itemHeight", null, "please enter any number not 0");
		}else if (it.getItemLength()<=0) {
			errors.rejectValue("itemHeight", null, "please enter any number more than  0");
		}
  
  if(StringUtils.isEmpty(it.getBaseCost())) {
		errors.rejectValue("baseCost", null, "please enter any number not 0");
		}else if (it.getItemLength()<=0) {
			errors.rejectValue("baseCost", null, "please enter any number more than  0");
		}
  
	if(StringUtils.isEmpty(it.getBaseCurrency())) {
		
		errors.rejectValue("baseCurrency", null, "please select any one opyion");
		
	}
  
	
	
	 if(!StringUtils.hasText(it.getItemCode())) {
			errors.rejectValue("itemDsc",null,"please enter any text");
		}else if(it.getItemDsc().length()<=10 && it.getItemDsc().length()<=15) {
			errors.rejectValue("itemDsc",null,"please enter text 10 to 15 letters");
		}
  
	}
	
	

}
