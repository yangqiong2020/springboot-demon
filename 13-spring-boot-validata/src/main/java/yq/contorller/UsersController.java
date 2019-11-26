package yq.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import yq.pojo.Users;

import javax.validation.Valid;

@Controller
public class UsersController {

    @RequestMapping("/addUser")
    public String showPage(Users users){
        return "add";
    }

    /**
     * 完成用户添加
     * @Valid开启对Users对象的校验
     * BindingResult:封装了校验的结果
     */
    @RequestMapping("/save")
    public String saveUser(@Valid Users users, BindingResult result){
        if(result.hasErrors()){
            System.out.println(999);
            return "add";
        }
            System.out.println(99999);
        System.out.println(users);
        return "ok";
    }
}
