package com.thesischecker.validators;

import com.thesischecker.models.IdModel;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Viciu on 2014-06-23.
 */
public class IdModelValidator implements Validator
{

    @Override
    public boolean supports(Class<?> aClass) {
        return IdModel.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        IdModel model = (IdModel) o;
    }
}
