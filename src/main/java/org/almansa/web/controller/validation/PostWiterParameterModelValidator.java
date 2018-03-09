package org.almansa.web.controller.validation;

import org.almansa.web.controller.dto.PostWriteParameterModel;
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
        return PostWriteParameterModel.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PostWriteParameterModel model = (PostWriteParameterModel)target;
        
        if(model.getName() == null || model.getName().length() < 10 || model.getName().length() > 100) {
            errors.rejectValue("name", "name.length", "제목은 10 ~ 150");
        }        
    }
}
