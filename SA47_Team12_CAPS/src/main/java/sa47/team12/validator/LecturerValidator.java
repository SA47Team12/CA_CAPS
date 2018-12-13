package sa47.team12.validator;

//import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import sa47.team12.model.Lecturer;


@Component
public class LecturerValidator implements org.springframework.validation.Validator {

	public LecturerValidator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Lecturer.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Lecturer l = (Lecturer) target;
		ValidationUtils.rejectIfEmpty(errors, "firstname", "The first name cannot be empty.");
		ValidationUtils.rejectIfEmpty(errors, "lastname", "The last name cannot be empty.");
		//ValidationUtils.rejectIfEmpty(errors, "password", "The password cannot be empty.");
		ValidationUtils.rejectIfEmpty(errors, "address", "The address cannot be empty.");
		ValidationUtils.rejectIfEmpty(errors, "email", "The email id cannot be empty.");
		/*ValidationUtils.rejectIfEmpty(errors, "gender", "The gender cannot be empty.");*/
		ValidationUtils.rejectIfEmpty(errors, "phone", "The phone number cannot be empty.");
	}
	
//	public boolean isValid(String contactField, ConstraintValidatorContext cxt) {
//        return contactField != null && contactField.matches("[0-9]+")
//          && (contactField.length() > 7) && (contactField.length() < 9);
//    }

}
