package sa47.team12.validator;

//import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import sa47.team12.model.Administrator;


@Component
public class AdminValidator implements org.springframework.validation.Validator {

	public AdminValidator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Administrator.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Administrator a = (Administrator) target;
	
		ValidationUtils.rejectIfEmpty(errors, "address", "The address cannot be empty.");
		ValidationUtils.rejectIfEmpty(errors, "email", "The email id cannot be empty.");
		ValidationUtils.rejectIfEmpty(errors, "phone", "The phone number cannot be empty.");
	}
	
//	public boolean isValid(String contactField, ConstraintValidatorContext cxt) {
//        return contactField != null && contactField.matches("[0-9]+")
//          && (contactField.length() > 7) && (contactField.length() < 9);
//    }

}
