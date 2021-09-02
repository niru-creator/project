package com.example.demo;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class controller {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	User user;
	
	@Autowired
	userRepository repo;
@RequestMapping("/home")
	public String handler(Model m) {
	
	m.addAttribute("title", "Home-Smart Contact Manager");
	
		return "home";
	}



@RequestMapping("/about")
public String handler1(Model m) {

m.addAttribute("title", "about-Smart Contact Manager");

	return "about";
}

@RequestMapping("/signup")
public String handler2(Model m) {

m.addAttribute("title", "Signup-Smart Contact Manager");
m.addAttribute("user",new User());
	return "signup";
}

@RequestMapping(value="/do_register",method=RequestMethod.POST)
public String handler3(@Valid @ModelAttribute("user") User user,BindingResult res,@RequestParam(value="agreement",defaultValue="false") boolean agreement,Model m)
{
	System.out.println("Agreement"+agreement);
	System.out.println("user"+user);
    if(res.hasErrors()) {
    	m.addAttribute("user", user);
    	return "signup";
    }
	
	user.setRole("ROLE_USER");
	user.setImage("default.png");
	user.setPassword(passwordEncoder.encode(user.getPassword()));
	user.setEnabled(true);
	User result=repo.save(user);
	
	m.addAttribute("user", result);
	return "home";
}

//handler for custom login
@RequestMapping("/signin")
public String handler4(Model m) {
	m.addAttribute("title"," Login Page");
	return "login";
	
}
}




