package yq.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import yq.pojo.Users;

@Controller
public class UsersController {

    @RequestMapping("/addUser")
    public String showPage(){
        return "add";
    }

    /**
     * 完成用户添加
     */
    @RequestMapping("/save")
    public String saveUser(Users users){
        System.out.println(users);
        return "ok";
    }
}
