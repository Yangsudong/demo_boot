package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomController {

	@Autowired CustomerRepository dao;
	@RequestMapping("/customer")
	public String list(Model model) {
		dao.findAll();
		model.addAttribute("list", dao.findAll());
		model.addAttribute("name","홍길동");
		return "list";
	}
	
	@RequestMapping("/findName")
	@ResponseBody
	public List<Customer> findName(Customer cust) {
		return dao.findByName(cust.getName());
	}
}
