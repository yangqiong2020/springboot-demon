package yq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import yq.pojo.Users;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    /**
     * 处理请求产生数据
     * @param model
     * @return
     */
    @RequestMapping("/showUser")
    public String showUser(Model model){
        List<Users> list = new ArrayList<>();
        list.add(new Users(1,20,"ls"));
        list.add(new Users(2,22,"ml"));
        list.add(new Users(3,23,"ww"));

        //需要一个model对象
        model.addAttribute("list",list);
        System.out.println("aaa");
        //跳转视图
        return "userList";
    }
}
