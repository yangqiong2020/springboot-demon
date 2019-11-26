package yq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * thymeleaf 案例
 */
@Controller
public class DemoController {
    @RequestMapping("/show")
    public String showInfo(Model model){
        model.addAttribute("msg","thymeleaf......");
        model.addAttribute("key",new Date());
                return "index";
    }

    @RequestMapping("/show2")
    public String showInfo2(Model model){
        model.addAttribute("sex" ,"男");
        model.addAttribute("num",1);
        return "index2";
    }
}
