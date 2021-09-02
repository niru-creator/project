package com.example.demo;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
@Autowired
userRepository repo;

@ModelAttribute
public void addcommondata(Model model,Principal p)
{
	String user=p.getName();
	System.out.println("user="+user);
	//model.addAttribute("username", user);
	User u=repo.getUserByUserName(user);
	model.addAttribute("username", u);
	System.out.println("userdetail"+u);
	
}

//dashboard home
	@RequestMapping("/index")
	public String dash(Model model) {
		
		model.addAttribute("title","User Dashboard");

		return "user/userdashboard";
	}
	
	//method for adding contact
	
	@RequestMapping("/addcontact")
	public String addcontact(Model model)
	{
		model.addAttribute("title","Add-Contact");
		model.addAttribute("contact", new Contact()); //sending blank object to view
		return "user/addcontact";
	}
	
	@PostMapping("/contact-process")
	public String contactprocess(@ModelAttribute Contact contact,Principal p)
	
	{ String user=p.getName();
	User user1=this.repo.getUserByUserName(user);
	contact.setUser(user1);
	user1.getContacts().add(contact);
	repo.save(user1);
	
		
		return "user/addcontact";
		
	}
	
	
}
