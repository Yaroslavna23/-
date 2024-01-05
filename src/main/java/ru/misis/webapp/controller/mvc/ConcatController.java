package ru.misis.webapp.controller.mvc;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.misis.webapp.dto.DigitConvDto;
import ru.misis.webapp.dto.ResultDto;
import ru.misis.webapp.service.TranslateService;


@Controller
public class ConcatController {

    private final TranslateService service;

    @Autowired
    public ConcatController(TranslateService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String indexPage(Model model, HttpSession session) {
        DigitConvDto TranslateData = (DigitConvDto) session.getAttribute("TranslateData");

        if (TranslateData == null) {
            TranslateData = new DigitConvDto();
            session.setAttribute("TranslateData", TranslateData);
        }

        model.addAttribute("TranslateData", TranslateData);
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@ModelAttribute DigitConvDto TranslateData, HttpSession session) {
        ResultDto resultDto = service.convert(TranslateData);

        session.setAttribute("TranslateData", TranslateData);
        session.setAttribute("result", resultDto.getResult());

        return "redirect:/";
    }
}
