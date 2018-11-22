package org.almansa.web.dto.validation;

import org.almansa.web.dto.PostWriteRequestModel;
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
        return PostWriteRequestModel.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    	PostWriteRequestModel model = (PostWriteRequestModel)target;
        
        if(model.getName() == null || model.getName().length() < 10 || model.getName().length() > 100) {
            errors.rejectValue("name", "name.length", "name.length.error");
        }        
    }
}