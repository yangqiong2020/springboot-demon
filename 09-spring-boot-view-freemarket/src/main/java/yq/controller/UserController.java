package yq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import yq.pojo.Users;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    /*
     * 处理请求，产生数据
     */
    @RequestMapping("/showUser")
    public String showUser(Model model){
        List<Users> list = new ArrayList<>();
        list.add(new Users(1,2,"zs1"));
        list.add(new Users(2,3,"zs2"));
        list.add(new Users(3,4,"zs3"));
        System.out.println(11111111);
        //需要一个Model对象
        model.addAttribute("list", list);
        //跳转视图
        return "userList";
    }
}
