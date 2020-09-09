package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String allUsers(ModelMap model) {
        List<User> users = userService.allUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping(value = "/add")
    public String addUser(Model model) { // addPage
        User user = new User();
        model.addAttribute("user" ,user);
        return "addUser";
    }

    @PostMapping(value = "/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

     @GetMapping(value = "/edit/{id}")
     public String editUser(ModelMap model, @PathVariable("id") Long id) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute("user") User user) {
        userService.edit(user);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteUserById(@RequestParam("id") Long id) {
        userService.remove(id);
        return "redirect:/";
    }

}
