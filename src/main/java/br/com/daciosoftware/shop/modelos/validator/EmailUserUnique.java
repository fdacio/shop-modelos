package br.com.daciosoftware.shop.modelos.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = { EmailUserUniqueValidator.class })
@Target({ ElementType.FIELD, ElementType.TYPE })
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface EmailUserUnique {
	
	String message() default "Email já existe";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };	

}