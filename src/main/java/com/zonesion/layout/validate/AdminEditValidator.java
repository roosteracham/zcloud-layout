package com.zonesion.layout.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.zonesion.layout.model.AdminForm;

/**    
 * @author andieguo andieguo@foxmail.com
 * @Description: TODO 
 * @date 2016年4月22日 下午4:52:42  
 * @version V1.0    
 */
@Component("adminEditValidator")
public class AdminEditValidator  implements Validator{
	
	@Autowired
	@Qualifier("emailValidator")
	EmailValidator emailValidator;
	
	@Autowired
	@Qualifier("phoneValidator")
	PhonelValidator phoneValidator;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return AdminForm.class.equals(clazz);
	}
	
	public boolean isNotNULL(String content){
		return content != null && !content.equals("");
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		AdminForm admin = (AdminForm)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nickname", "NotEmpty.adminForm.nickname");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "NotEmpty.adminForm.phoneNumber");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.adminForm.email");
		
		if(isNotNULL(admin.getNickname()) && admin.getNickname().length() > 20){
			errors.rejectValue("nickname", "Size.adminForm.nickname");
		}
		if(isNotNULL(admin.getPhoneNumber()) && admin.getPhoneNumber().length() > 20){
			errors.rejectValue("phoneNumber", "Size.adminForm.phoneNumber");
		}
		if(isNotNULL(admin.getEmail()) && admin.getEmail().length() > 20){
			errors.rejectValue("email", "Size.adminForm.email");
		}
		if(isNotNULL(admin.getEmail()) && !emailValidator.valid(admin.getEmail())){
			errors.rejectValue("email", "Pattern.adminForm.email");
		}
		if(isNotNULL(admin.getPhoneNumber())&& !phoneValidator.valid(admin.getPhoneNumber())){
			errors.rejectValue("phoneNumber", "Pattern.adminForm.phoneNumber");
		}
	}

}
