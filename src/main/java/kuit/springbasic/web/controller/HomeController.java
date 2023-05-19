package kuit.springbasic.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
public class HomeController {

    //@RequestMapping(value="/", method= RequestMethod.GET)
    @GetMapping("/")
    public String showHome(Model model) {
        log.info("HomeController.showHome");

        // 코드 추가 필요

        return "home";
    }

}
