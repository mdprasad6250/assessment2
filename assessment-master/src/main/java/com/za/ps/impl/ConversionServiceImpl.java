package com.za.ps.impl;

import com.za.ps.model.Output;
import com.za.ps.service.ConversionService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by Durga on 25/05/2020.
 */
@Service
public class ConversionServiceImpl implements ConversionService {

    public Output calculateConversion(String conversionMnemonic, BigDecimal value) {
        Output output = new Output();
        if("ktoc".equals(conversionMnemonic)){
            output.setValue(String.valueOf(value.floatValue() - 273.15));
        }else if("ctok".equals(conversionMnemonic)){
            output.setValue(String.valueOf(value.floatValue() + 273.15));
        }else if("mtok".equals(conversionMnemonic)){
            output.setValue(String.valueOf(value.floatValue() * 1.6f));
        }else if("ktom".equals(conversionMnemonic)){
            output.setValue(String.valueOf(value.floatValue() / 1.6f));
        }
        return output;
    }
}