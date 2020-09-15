package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class AdminController {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/admin")
	public String allUsers(ModelMap model) {
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

	@PostMapping(value = "/editUser/{id}")
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

	@PostMapping("/delete/{id}")
	public String deleteUserById(@PathVariable("id") Long id) {
		userService.remove(id);
		return "redirect:/admin";
	}
}
