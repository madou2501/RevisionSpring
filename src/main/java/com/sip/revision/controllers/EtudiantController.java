package com.sip.revision.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sip.revision.entities.*;

@Controller
@RequestMapping("/etudiant")
public class EtudiantController {
          public static	List<Etudiant> students = new ArrayList<>();
	static {
		
		students.add(new Etudiant("Mahdi","madou2501@gmail.com",30));
		students.add(new Etudiant("Sana","sana2501@gmail.com",31));
		students.add(new Etudiant("radhwen","radhwen2501@gmail.com",40));
		
	}
	
	@RequestMapping("/list")
	public String listEtudiant(Model m)
	{
		
		
		m.addAttribute("students", students);
	return "etudiant/listEtudiant";
	}		
	
	@GetMapping("/add")
	public String formAdd(Model m)
	{Etudiant e = new Etudiant();
	m.addAttribute("etudiant", e);	
	return "etudiant/addEtudiant";
	}
	
	
	@PostMapping("/add")
	//@ResponseBody
	//public String saveEtudiant(@RequestParam("nom") String nom,@RequestParam("email") String email,@RequestParam("age") int age)
	public String saveEtudiant( Etudiant etudiant)
	{
		
	//return "etudiant/saveEtudiant";
		//return nom+" "+email+" "+age;
		Etudiant e = new Etudiant(etudiant.getNom(),etudiant.getEmail(),etudiant.getAge());
		students.add(e);
		return "redirect:list";
		
	}
		
	

}
