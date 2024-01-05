package ru.misis.webapp.service;

import org.springframework.stereotype.Service;
import ru.misis.webapp.dto.DigitConvDto;
import ru.misis.webapp.dto.ResultDto;


@Service
public class TranslateService {

    public ResultDto convert(DigitConvDto intData){
        String result = "";
        result += Integer.toBinaryString(intData.getDecimalNum());
        return new ResultDto(result);
    }
}
