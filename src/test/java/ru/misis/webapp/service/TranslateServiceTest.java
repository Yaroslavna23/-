package ru.misis.webapp.service;

import org.junit.jupiter.api.Test;
import ru.misis.webapp.dto.DigitConvDto;
import ru.misis.webapp.dto.ResultDto;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TranslateServiceTest {

    // Test for a normal conversion scenario
    @Test
    public void testConvertNormal() {
        TranslateService service = new TranslateService();
        DigitConvDto dto = new DigitConvDto();
        dto.setDecimalNum(10); // Setting the decimal number to 10
        ResultDto result = service.convert(dto);
        assertEquals("1010", result.getResult(), "The binary representation of 10 should be 1010");
    }

    // Test for edge case, like the minimum integer value
    @Test
    public void testConvertEdgeCase() {
        TranslateService service = new TranslateService();
        DigitConvDto dto = new DigitConvDto();
        dto.setDecimalNum(0); // Setting the decimal number to 0
        ResultDto result = service.convert(dto);
        assertEquals("0", result.getResult(), "The binary representation of 0 should be 0");
    }

    // Add more tests for other edge cases or invalid inputs if necessary
}
