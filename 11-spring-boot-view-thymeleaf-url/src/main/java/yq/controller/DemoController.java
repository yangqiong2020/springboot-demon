package yq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.WebParam;

 @Controller
//@RestController
public class DemoController {
    @RequestMapping("/{page}")
    public String showInfo(@PathVariable String page, Integer id, String name){
        System.out.println(id+"---------->"+name);
        return page;
    }
    //@GetMapping("/show")
    @RequestMapping("/show")
    public String showInfo1(Model model){
        return "index";
    }
    @RequestMapping("/show2")
    public String showInfo2(Model model,String id ,String name){
        System.out.println(id+"-----"+name);
        model.addAttribute("id",id);
        model.addAttribute("name",name);
        return "show" ;
    }
}
