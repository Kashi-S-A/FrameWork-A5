package com.expensetracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.expensetracker.entity.User;
import com.expensetracker.service.ExpenseTrackerService;
import com.expensetracker.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ExpenseTrackerController {

	@Autowired
	private ExpenseTrackerService expenseService;

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String loginPage() {
		return "login.jsp";
	}

	@GetMapping("/register")
	public String registerPage(Model model) {
		model.addAttribute("user", new User());
		return "register.jsp";
	}

	@PostMapping("/register")
	public String registerUser(User user, Model model) {
		boolean saved = userService.save(user);
		if (saved) {
			model.addAttribute("succmsg", "Registered Successfully");
		} else {
			model.addAttribute("errmsg", "UserName : " + user.getUserName() + " is Already Registered");
		}
		return "login.jsp";
	}

	@PostMapping("/login")
	public String loginUser(HttpServletRequest request, Model model) {
		String un = request.getParameter("username");
		String pwd = request.getParameter("password");

		boolean login = userService.login(un, pwd);
		if (login) {
			//create a session to maintain logged in user information
			return "welcome.jsp";
		} else {
			model.addAttribute("errmsg", "Invalid credentials");
			return "login.jsp";
		}
	}

}
