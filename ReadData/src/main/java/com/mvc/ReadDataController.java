package com.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReadDataController {

	@RequestMapping("/page") // will take both get and post
	public String getData() {
		System.out.println("got the req");
		return "test.html";
	}

	@GetMapping("/read") // only get req
	public String readData(HttpServletRequest request) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pwd = request.getParameter("password");

		System.out.println(name);

		System.out.println(email);

		System.out.println(pwd);

		System.out.println("got the data");
		return "display.html";
	}

	@GetMapping("/disp")
	public String display(Model model) {

		model.addAttribute("userId", 101);
		model.addAttribute("userName", "Dinga");

		model.addAttribute("person", new Person("Manga", 2345678L, 43));

		return "display.jsp";
	}

	@GetMapping("/pass")
	public ModelAndView passData() {

		ModelAndView mv = new ModelAndView("pagea.jsp");
//		mv.setViewName("pagea.jsp");

		mv.addObject("stuId", 100);
		mv.addObject("stuName", "Manga");

		mv.addObject("newPerson", new Person("Penga", 3456789l, 25));

		return mv;
	}

}
