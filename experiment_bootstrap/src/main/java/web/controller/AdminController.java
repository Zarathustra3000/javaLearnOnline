package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.service.UserService;

import java.util.HashSet;
import java.util.Set;

@Controller
public class AdminController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/admin")
    public String allUsers(ModelMap model) {
        User thisUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("thisUser", thisUser);
        model.addAttribute("listUsers", userService.allUsers());
        model.addAttribute("allRoles", userService.getAllRoles());
        model.addAttribute("newUser", new User());
        return "admin";
    }

    @PostMapping(value = "/createUser")
    public String addUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "/editUser/{id}")
    public String editUser(ModelMap model, @PathVariable("id") Long id) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        model.addAttribute("allRoles", userService.getAllRoles());
        return "editUser";
    }

    @PostMapping(value = "/editUser")
    public String edit(@ModelAttribute("user") User user) {
        userService.edit(user);
        return "redirect:/admin";
    }

    @PostMapping("/admin/edit")
    public String editUser(@RequestParam(value = "idEdit", required = false) Long id,
                           @RequestParam(value = "firstNameEdit", required = false) String firstName,
                           @RequestParam(value = "lastNameEdit", required = false) String lastName,
                           @RequestParam(value = "ageEdit", required = false) int age,
                           @RequestParam(value = "emailEdit", required = false) String email,
                           @RequestParam(value = "passwordEdit", required = false) String password,
                           @RequestParam(value = "editRole", required = false) String role,
                           Model model) {

        model.addAttribute("allRoles", userService.getAllRoles());
        User user = userService.getById(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAge(age);
        user.setMail(email);

        if (password == null){
            user.setPassword(user.getPassword());
        } else {
            user.setPassword(password);
        }

        Set<Role> roleSet = new HashSet<>();
        if (role.contains("ROLE_USER")){
            roleSet.add(new Role("ROLE_USER"));
            user.setRoles(roleSet);
        }
        if (role.contains("ROLE_ADMIN")) {
            roleSet.add(new Role("ROLE_ADMIN"));
            user.setRoles(roleSet);
        }
        userService.edit(user);
        return "redirect:/admin";
    }

    @PostMapping("/delete")
    public String deleteUserById(@RequestParam(value = "idDelete", required = false) Long id) {
        userService.remove(id);
        return "redirect:/admin";
    }
}
