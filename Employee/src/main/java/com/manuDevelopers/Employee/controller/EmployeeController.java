package com.manuDevelopers.Employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manuDevelopers.Employee.DAO.EmployeeDAO;
import com.manuDevelopers.Employee.DTO.RegistrDTO;



@RestController
@RequestMapping
public class EmployeeController {

	@Autowired
	EmployeeDAO employeeDAO;

	@GetMapping("get")
	public String getName() {
		return "Manu";
	}

	@PostMapping("save")
	public RegistrDTO registerDetails(@RequestBody RegistrDTO data) {
		System.out.println(data.getName());
		employeeDAO.save(data);
		return data;
	}
	
	
	@PostMapping("displays")
	public String displayRecords() {
		System.out.println("wait a second display method is calling");
		employeeDAO.display();
		return "check in the localsystem";
		
	}
	
	@GetMapping("update")
	public String updatePassByMail(	@RequestParam String email, @RequestParam String pass) {
		return "email is : " + email + "\t" + "password is : " + pass;
	}
	
//	display by id method
	@PostMapping("getById")
	public String getByName(@RequestParam int id) {
		employeeDAO.displayById(id);
		return "check in console output";
		
	}

	

	//display by name
	@PostMapping("getByName")
	public String getByName(@RequestParam String name) {
		employeeDAO.displayByName(name);
		return "check in console output";
		
	}
		
	
	//display by contact
	@PostMapping("getByContact")
	public String getByContact(@RequestParam long contact) {
		employeeDAO.displayByContact(contact);
		return "check in console output";
		
	}


	//display by email
	@PostMapping("getByEmail")
	public String getByEmail(@RequestParam String email) {
		employeeDAO.displayByEmail(email);
		return "check in console output";
		
	}
			
	//update by id
		@PostMapping("updateById")
		public String updateByid(	@RequestParam int id, @RequestParam long contact) {
			employeeDAO.updateById(id,contact);
			return "check in console output";
			
		}
		
		
		
//delete by name
	@PostMapping("deleteByName")
	public String deleteByName(@RequestParam String name) {
		employeeDAO.deleteByName(name);
		return "check in console output";
		
	}
}
