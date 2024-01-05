package ru.misis.webapp.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.misis.webapp.dto.DigitConvDto;
import ru.misis.webapp.dto.ResultDto;
import ru.misis.webapp.service.TranslateService;


@RestController
@RequestMapping("/api/dev")
public class RestConcatController {

    private final TranslateService service;

    @Autowired
    public RestConcatController(TranslateService service) {
        this.service = service;
    }

    @PostMapping("/convert")
    public ResponseEntity<ResultDto> concatStrings(@RequestBody DigitConvDto TranslateData) {
        ResultDto resultDto = service.convert(TranslateData);

        return new ResponseEntity<>(resultDto, HttpStatus.OK);
    }
}
