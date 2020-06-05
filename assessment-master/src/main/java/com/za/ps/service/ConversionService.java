package com.za.ps.service;

import com.za.ps.model.Output;

        import java.math.BigDecimal;

/**
 * Created by Durga on 25/05/2020.
 */
public interface ConversionService {
    Output calculateConversion(String conversionMnemonic, BigDecimal value);
}