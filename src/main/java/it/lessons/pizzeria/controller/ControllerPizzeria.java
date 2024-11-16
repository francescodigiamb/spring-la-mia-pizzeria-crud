package it.lessons.pizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.lessons.pizzeria.repository.PizzaRepository;

@Controller
@RequestMapping ("/pizza")
public class ControllerPizzeria {

	@Autowired 
	private PizzaRepository pizzaRepo;
	
	@GetMapping 
	public String index (Model model) {
		
		model.addAttribute("pizza", pizzaRepo.findAll());
		
		return "/pizza/index";
	}
	
		
}
