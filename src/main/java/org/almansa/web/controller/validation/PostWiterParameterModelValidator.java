package org.almansa.web.controller.validation;

import org.almansa.web.controller.dto.PostWriteRequestDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * 
 * @author skennel
 *
 */
@Component
public class PostWiterParameterModelValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return PostWriteRequestDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    	PostWriteRequestDTO model = (PostWriteRequestDTO)target;
        
        if(model.getName() == null || model.getName().length() < 10 || model.getName().length() > 100) {
            errors.rejectValue("name", "name.length", "name.length.error");
        }        
    }
}