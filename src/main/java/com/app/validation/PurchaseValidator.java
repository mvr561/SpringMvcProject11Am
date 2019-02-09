package com.app.validation;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Purchase;

@Component
public class PurchaseValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Purchase.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {

		Purchase purchase=(Purchase)target;

		//checking text empty
		if (!StringUtils.hasText(purchase.getOrderCode().trim())) {
			errors.rejectValue("orderCode", null, "please enter code !");
		}else if (!Pattern.matches("[A-Z]{4,6}", purchase.getOrderCode())) {
			errors.rejectValue("orderCode", null, "code shold be 4-6 uppercase lettrs !");
		}

		//checking drop down empty
		if (StringUtils.isEmpty(purchase.getShipmentMode())) {
			errors.rejectValue("shipmentMode", null, "please choose any one !");
		}	

		//checking drop down empty
		if (StringUtils.isEmpty(purchase.getVendor())) {
			errors.rejectValue("vendor", null, "please choose any one !");
		}


		//checking radio button empty
		if(StringUtils.isEmpty(purchase.getQuaCheck())) {
			errors.rejectValue("quaCheck", null, "please choose atleast one !");
		}
		//text check
		if (!StringUtils.hasText(purchase.getRefNumber().trim())) {
			errors.rejectValue("refNumber", null, "please enter reference number !");
		} else if(!Pattern.matches("[A-Z 0-9]{8,12}", purchase.getRefNumber())){
			errors.rejectValue("refNumber", null, "reference number must be 8-12 combination of uppercase letters and digits ");
		}

		//checking drop down empty
		if (StringUtils.isEmpty(purchase.getOrderStatus())) {
			errors.rejectValue("orderStatus", null, "please choose any one !");
		}

		//checking text area empty and size
		if (!StringUtils.hasText(purchase.getOrderDesc().trim())) {
			errors.rejectValue("orderDesc", null, "please enter description!");
		} else if(purchase.getOrderDesc().length()<10 || purchase.getOrderDesc().length()>100) {
			errors.rejectValue("orderDesc", null, "description should be 10-100 characters!");
		}
	}

}
