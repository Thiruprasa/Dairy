package com.org.diary.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.diary.bussiness.EntryBussinessInterface;
import com.org.diary.bussiness.UserBussinessInterface;
import com.org.diary.entities.Entry;
import com.org.diary.entities.User;

@Controller()
public class HomeController {

	@Autowired
	private UserBussinessInterface userBussinessInterface;
	@Autowired
	private EntryBussinessInterface entryBussinessInterface;
	
	@Autowired
	HttpSession session; // create session 
	
	
	public EntryBussinessInterface getEntryBussinessInterface() {
		return entryBussinessInterface;
	}

	public void setEntryBussinessInterface(EntryBussinessInterface entryBussinessInterface) {
		this.entryBussinessInterface = entryBussinessInterface;
	}

	public UserBussinessInterface getUserBussinessInterface() {
		return userBussinessInterface;
	}

	public void setUserBussinessInterface(UserBussinessInterface userBussinessInterface) {
		this.userBussinessInterface = userBussinessInterface;
	}

	@RequestMapping("login")
	public ModelAndView loginPage()
	{
		ModelAndView model = new ModelAndView("loginpage");
		return model;
		
	}
	
	@RequestMapping("register")
	public ModelAndView registrationPage()
	{
		ModelAndView model = new ModelAndView("registrationpage");
		return model;
		
	}
	@RequestMapping(value="saveuser" ,method=RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute("user") User user)
	{
		// Save the user details in the data base
	    userBussinessInterface.save(user);
		ModelAndView model = new ModelAndView("registrationsuccess");
		return model;
		
	}
	@RequestMapping(value="userhome" ,method=RequestMethod.POST)
	public ModelAndView userHome(@ModelAttribute("user")User user)
	{
		ModelAndView model = new ModelAndView("loginpage");
		
		System.out.println("user name:"+user.getUsername());
		
		User user1 = userBussinessInterface.findByUsername(user.getUsername());
		
		System.out.println("user1 id:"+user1.getId());
		
		if(user1 != null && user1.getPassword().equals(user.getPassword()))
		{
			System.out.println("entered into if");
			
			
			model.setViewName("userhomepage");
			model.addObject("user", user1.getUsername());
			
			session.setAttribute("user", user1); // set object for session object..
			List<Entry> entries = null;
			try {
				entries = entryBussinessInterface.findByUserId(user1.getId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			model.addObject("entrieslist", entries);
		}
		return model;
	}
	
	@RequestMapping("addentry")
	public ModelAndView addEntry()
	{
		ModelAndView model = new ModelAndView("addentryform");
		User user1 = (User) session.getAttribute("user");
		if(user1!=null)
			System.out.println("user1 id is :"+user1.getId());
		else
			System.out.println("user1 is null");
		model.addObject("user", user1);
		return model;
	}
	
	@RequestMapping("saveentry")
	public ModelAndView saveEntry(@ModelAttribute("entry") Entry entry)
	{
		ModelAndView model = new ModelAndView("userhomepage");
		entryBussinessInterface.save(entry);
		
		User user1 = (User) session.getAttribute("user");// Retrieve the object 
		
		List<Entry> entries = null;
		try {
			entries = entryBussinessInterface.findByUserId(user1.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addObject("entrieslist", entries);
		return model;
	}
	
	@RequestMapping("viewentry")
	public ModelAndView viewEntry(@RequestParam("id") int id)
	{
		ModelAndView model = new ModelAndView("displayentry");
		
		Entry entry = entryBussinessInterface.findById(id);
		model.addObject("entry", entry);
		return model;
	}
	
	@RequestMapping("backtohome")
	public ModelAndView userhomepage()
	{
		ModelAndView model = new ModelAndView("userhomepage");
		User user1 = (User) session.getAttribute("user");// Retrieve the object
		List<Entry> entries = null;
		try {
			entries = entryBussinessInterface.findByUserId(user1.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addObject("entrieslist", entries);
		
		return model;
	}
	
	@RequestMapping("updateentry")
	public ModelAndView updateEntry(@RequestParam("id") int id)
	{
		ModelAndView model = new ModelAndView("displayupdateentry");
		
		Entry entry = entryBussinessInterface.findById(id);
		model.addObject("entry", entry);
		User user1 = (User) session.getAttribute("user");
		if(user1 == null )
		{
			model.setViewName("loginpage");
		}
		return model;
	}
	
	@RequestMapping("processentryupdate")
	public ModelAndView processEntryUpdate(@ModelAttribute("entry") Entry entry)
	{
		ModelAndView model = new ModelAndView("userhomepage");
		entryBussinessInterface.update(entry);
		
		User user1 = (User) session.getAttribute("user");// Retrieve the object 
		
		List<Entry> entries = null;
		try {
			entries = entryBussinessInterface.findByUserId(user1.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addObject("entrieslist", entries);
		return model;
	}
	
	
	@RequestMapping("deleteentry")
	public ModelAndView deleteEntry(@RequestParam("id") int id)
	{
		ModelAndView model = new ModelAndView("userhomepage");
		Entry entry = entryBussinessInterface.findById(id);
		User user1 = (User) session.getAttribute("user");
		if(user1 == null )
			model.setViewName("loginpage");
		else
		entryBussinessInterface.delete(entry);
	
		List<Entry> entries = null;
		try {
			entries = entryBussinessInterface.findByUserId(user1.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addObject("entrieslist", entries);
		if(user1 == null )
		{
			model.setViewName("loginpage");
		}
		return model;
	}
	

	@RequestMapping("signout")
	public ModelAndView signout()
	{
		ModelAndView model = new ModelAndView("loginpage");
		session.invalidate();
		return model;
		
	}
}
