package com.thesischecker.utils;

import junit.framework.Assert;
import org.junit.Test;

public class ValidationUtilTest {

    @Test
    public void testValidateDate() throws Exception {
        String date = "2014-07-03";
        Assert.assertEquals(true, ValidationUtil.validateDate(date));
        date = "fdkslajf";
        Assert.assertEquals(false, ValidationUtil.validateDate(date));
        date = "2014-05-45";
        Assert.assertEquals(false, ValidationUtil.validateDate(date));
        date = "2014-80-12";
        Assert.assertEquals(false, ValidationUtil.validateDate(date));
    }

    @Test
    public void testValidateDateRange() throws Exception {
        String dateFrom = "2014-07-03";
        String dateTo = "2014-08-05";
        Assert.assertEquals(true, ValidationUtil.validateDateRange(dateFrom, dateTo));
        dateTo = "2014-03-04";
        Assert.assertEquals(false, ValidationUtil.validateDateRange(dateFrom, dateTo));
    }
}