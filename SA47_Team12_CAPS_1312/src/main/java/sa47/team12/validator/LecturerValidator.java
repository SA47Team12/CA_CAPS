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
		Lecturer s = (Lecturer) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "The first name cannot be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "The last name cannot be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "The address cannot be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Email Id cannot be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "Phone Number cannot be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Password cannot be empty.");
}
}
