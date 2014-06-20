package com.thesischecker.validators;

import com.thesischecker.models.ResourcesModel;
import com.thesischecker.utils.Constants;
import com.thesischecker.utils.ValidationUtil;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author Tomasz Morek
 */
public class ResourcesModelValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return ResourcesModel.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ResourcesModel model = (ResourcesModel) o;
        this.validateDate("dateFrom", model.getDateFrom(), errors);
        this.validateDate("dateTo", model.getDateTo(), errors);
        if (!errors.hasErrors()) {
            this.validateDateRange(model.getDateFrom(), model.getDateTo(),errors);
        }
    }

    /**
     * Validate date
     * @param fieldName
     * @param date
     * @param errors
     */
    public void validateDate(String fieldName, String date, Errors errors) {
        if (date != null && date.length() > 0) {
            if (!ValidationUtil.validateDate(date)) {
                errors.rejectValue(fieldName, fieldName, Constants.INCORRECT_DATE);
            }
        }
    }

    /**
     * Validate date range
     * @param dateFrom
     * @param dateTo
     * @param errors
     */
    public void validateDateRange(String dateFrom, String dateTo, Errors errors) {
        if (dateFrom != null && dateTo != null
            && dateFrom.length() > 0 && dateTo.length() > 0) {
            if (!ValidationUtil.validateDateRange(dateFrom, dateTo)) {
                errors.rejectValue("dateTo", "dateTo", Constants.DATE_RANGE_ERROR);
            }
        }
    }
}
