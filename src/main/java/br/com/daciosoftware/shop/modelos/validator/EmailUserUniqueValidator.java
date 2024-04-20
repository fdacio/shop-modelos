package br.com.daciosoftware.shop.modelos.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.daciosoftware.shop.modelos.dto.UserDTO;
import br.com.daciosoftware.shop.modelos.service.UserServiceValidation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailUserUniqueValidator implements ConstraintValidator<EmailUserUnique, String> {

	@Autowired
	UserServiceValidation userServiceValidation;
	
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		Optional<UserDTO> user = userServiceValidation.findUserByEmail(email);
		if (user.isPresent()) {
			return false;
		}
		return true;
	}

}
