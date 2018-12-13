package sa47.team12.validator;

//import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import sa47.team12.model.Student;


@Component
public class StudentValidator implements org.springframework.validation.Validator {

	public StudentValidator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Student.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Student s = (Student) target;

		ValidationUtils.rejectIfEmpty(errors, "firstname", "The Employee Id field cant be empty.");
		ValidationUtils.rejectIfEmpty(errors, "lastname", "error.employee.employeeid.empty");
	    System.out.println(s.toString());


		ValidationUtils.rejectIfEmpty(errors, "email", "email cannot be empty");
		ValidationUtils.rejectIfEmpty(errors, "phone", "phone cannot be empty");
		ValidationUtils.rejectIfEmpty(errors, "address", "Address cannot be empty");
		System.out.println(s.toString());

	}
	
//	public boolean isValid(String contactField, ConstraintValidatorContext cxt) {
//        return contactField != null && contactField.matches("[0-9]+")
//          && (contactField.length() > 7) && (contactField.length() < 9);
//    }

}
