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
		/*ValidationUtils.rejectIfEmpty(errors, "firstname", "The first name cannot be empty.");*/
		ValidationUtils.rejectIfEmpty(errors, "lastname", "The last name cannot be empty.");
		//ValidationUtils.rejectIfEmpty(errors, "password", "The password cannot be empty.");
		ValidationUtils.rejectIfEmpty(errors, "address", "The address cannot be empty.");
		ValidationUtils.rejectIfEmpty(errors, "email", "The email cannot be empty.");
		/*ValidationUtils.rejectIfEmpty(errors, "phone", "The phone number cannot be empty.");*/
		ValidationUtils.rejectIfEmpty(errors, "gender", "Gender cannot be empty.");
		if((s.getPhone().length()!=8))
		{
		errors.rejectValue("phone", "phone.length", "Please enter 8 digits only");
		}
		else 
		for(int i =0; i<(s.getPhone().length()-1);i++)
		{
		if((s.getPhone().substring(i,i+1).compareTo("0")<0)||(s.getPhone().substring(i,i+1).compareTo("9")>0))
		{
		errors.rejectValue("phone", "phone.length", "Please enter digits only");
		break;
		}
		}
		for(int i =0; i<(s.getFirstname().length()-1);i++)
		{
		if((s.getFirstname().substring(i,i+1).toUpperCase().compareTo("A")<0)||(s.getPhone().substring(i,i+1).toUpperCase().compareTo("Z")>0))
		{
		errors.rejectValue("firstname", "firstname.length", "Please enter alphabets only");
		break;
		}
		}
	}
}
