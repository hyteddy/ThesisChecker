package com.thesischecker.controller;

import com.thesischecker.models.IdPairModel;
import com.thesischecker.services.interfaces.IAnalysisService;
import com.thesischecker.utils.Constants;
import com.thesischecker.utils.ResponseUtil;
import com.thesischecker.validators.IdPairModelValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Viciu on 2014-06-23.
 */
public class AnalysisController
{
    @Autowired
    private IAnalysisService analysisService;

    @RequestMapping(value = "/getAnalysis", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseUtil get(@RequestBody IdPairModel idPairModel,
                            BindingResult result)
    {
        IdPairModelValidator validator = new IdPairModelValidator();
        validator.validate(idPairModel, result);

        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            return new ResponseUtil(Constants.FORM_VALIDATION_ERRORS, errors);
        } else {
            List<String> resources = this.analysisService.get(idPairModel.getId1(),idPairModel.getId2());
            if (resources.size() != 0) {
                return new ResponseUtil(resources);
            } else {
                return new ResponseUtil(Constants.NO_RECORDS_FOUND);
            }
        }
    }
}
