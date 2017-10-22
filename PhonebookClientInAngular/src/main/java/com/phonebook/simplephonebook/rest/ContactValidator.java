package com.phonebook.simplephonebook.rest;



import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import model.Contact;


public class ContactValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Contact.class.equals(clazz);
	}

	public void validate(Object obj, Errors errors) {
		Contact user = (Contact) obj;
		if (user.getName() == null || user.getName().length() < 1) {
			errors.rejectValue("name", "name.empty");
		}

	}

}
