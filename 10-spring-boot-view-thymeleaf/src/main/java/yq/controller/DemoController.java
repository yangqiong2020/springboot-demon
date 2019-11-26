package yq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import yq.pojo.Users;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

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

    @RequestMapping("/show3")
    public String showInfo3(Model model){
        List<Users> list = new ArrayList<>();
        list.add(new Users(1,20,"张三"));
        list.add(new Users(2 ,22,"李四"));
        list.add(new Users(3,24,"王五"));
        model.addAttribute("list", list);
        return "index3";
    }

    @RequestMapping("/show4")
    public String showInfo4(Model model){
        Map<String, Users> map = new HashMap<>();
        map.put("u1", new Users(1,21,"张三1"));
        map.put("u2", new Users(1,21,"张三2"));
        map.put("u3", new Users(1,23,"张三3"));
        model.addAttribute("map", map);
        return "index4";
    }

    @RequestMapping("/show5")
    public String showInfo5(HttpServletRequest request,Model model){
        request.setAttribute("req","HttpServletRequest");
        request.getSession().setAttribute("sess","HttpSession");
        request.getSession().getServletContext().setAttribute("app","servletContext");
        model.addAttribute("model","model");
        return "index5";
    }
}
