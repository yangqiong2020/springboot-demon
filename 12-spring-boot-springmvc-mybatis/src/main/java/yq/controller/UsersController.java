package yq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import yq.pojo.Users;
import yq.service.UsersService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;
    /**
     * 页面跳转
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }

    /**
     * 添加用户
     */
    @RequestMapping("/addUser")
    public String addUser(Users users){
        System.out.println(111111);
        this.usersService.addUser(users);
        return "ok";
    }

    @RequestMapping("/findUserAll")
    public String findUserAll(Model model){
        List<Users> userAll = this.usersService.findUserAll();
        model.addAttribute("list",userAll);
        return "showUsers";
    }
    /**
     * 通过id查用户
     */
    @RequestMapping("/findUserById")
    public String findUserById(Model model,Integer userid){
        System.out.println("userid ...."+userid);
        Users users = this.usersService.findUserById(userid);
        model.addAttribute("user",users);
        return "updateUser";
    }

    /**
     * 修改用户
     * @param users
     * @return
     */
    @RequestMapping("/editUser")
    public String editUser(Users users){
        this.usersService.updateUser(users);
        return "ok";
    }

    /**
     * 删除用户
     */
    @RequestMapping("deleteUser")
    public String deleteUser(Integer userid){
        this.usersService.deleteUser(userid);
        return "redirect:/users/findUserAll";  //这里必须是redirect重定向到
    }
}
