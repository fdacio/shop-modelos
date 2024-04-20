package br.com.daciosoftware.shop.modelos.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.daciosoftware.shop.modelos.dto.UserDTO;
import br.com.daciosoftware.shop.modelos.service.UserServiceValidation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CPFUserUniqueValidator implements ConstraintValidator<CPFUserUnique, String> {
	
	@Autowired
	UserServiceValidation userServiceValidation;
	
	@Override
	public boolean isValid(String cpf, ConstraintValidatorContext context) {
		
		Optional<UserDTO> user = userServiceValidation.findUserByCPF(cpf);
		System.err.println(user);
		if (user.isPresent()) {
			return false;
		}

		return true;

	}

}
