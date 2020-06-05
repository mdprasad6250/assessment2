package com.za.ps.controller;

import com.za.ps.model.Output;
import com.za.ps.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import static org.springframework.http.HttpStatus.OK;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Created by Durga on 25/05/2020.
 */
@RestController
public class ConversionController {

    @Autowired
    ConversionService conversionService;

    @RequestMapping(value = "/conversion/{conversionMnemonic}/{value}", method = GET)
    @ResponseBody
    public HttpEntity<Output> fetchConversionValue(@PathVariable("conversionMnemonic") String conversionMnemonic,
                                                        @PathVariable("value") BigDecimal value) {
        Output responseOutput = conversionService.calculateConversion(conversionMnemonic,value);
        return new ResponseEntity<Output>(responseOutput, OK);
    }
}