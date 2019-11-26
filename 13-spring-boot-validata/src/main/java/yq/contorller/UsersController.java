package yq.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import yq.pojo.Users;

import javax.validation.Valid;

@Controller
public class UsersController {
    /**
     * 如果想为传递的对象更改名称，可以使用@ModelAttribute("aa") 表示当前传递的对象的key为aa
     * 那么我们在页面中获取该对象的key也需要修改为aa
     * @param users
     * @return
     */
    @RequestMapping("/addUser")
    public String showPage(@ModelAttribute("aa") Users users){
        return "add";
    }

    /**
     * 完成用户添加
     * @Valid开启对Users对象的校验
     * BindingResult:封装了校验的结果
     */
    @RequestMapping("/save")
    public String saveUser(@ModelAttribute("aa")@Valid Users users, BindingResult result){
        if(result.hasErrors()){
            System.out.println(999);
            return "add";
        }
            System.out.println(99999);
        System.out.println(users);
        return "ok";
    }
}
