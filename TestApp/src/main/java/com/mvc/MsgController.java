package com.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MsgController {

	// API's
	@RequestMapping("/msg")
//	@ResponseBody
	public String getMessage() {
		System.out.println("API is triggered");
		return "msg.jsp";
	}

	@RequestMapping("/test")
	public String sayHello() {
		System.out.println("Hellooo");
		return "test.html";
	}
}
