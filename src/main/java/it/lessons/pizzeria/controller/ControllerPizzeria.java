package it.lessons.pizzeria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.lessons.pizzeria.model.Pizza;
import it.lessons.pizzeria.repository.PizzaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/pizzeria")
public class ControllerPizzeria {

	@Autowired
	private PizzaRepository pizzaRepo;

	@GetMapping
	public String index(Model model, @RequestParam(name = "keyword", required = false) String keyword) {
		List<Pizza> lepizze;

		if (keyword != null && !keyword.isBlank()) {
			lepizze = pizzaRepo.findByDescrizione(keyword);
			model.addAttribute("keyword", keyword);
		} else {
			lepizze = pizzaRepo.findAll();
		}

		model.addAttribute("pizze", lepizze);

		return "/pizza/index";
	}

	@GetMapping("/show/{id}")
	public String show(@PathVariable("id") Integer id, Model model) {

		Optional<Pizza> pizzOptional = pizzaRepo.findById(id);
		if (pizzOptional.isPresent()) {
			model.addAttribute("pizze", pizzOptional.get());
		}

		return "/pizza/show";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("pizza", new Pizza());
		return "/pizza/create";
	}

	@PostMapping("/create")
	public String store(@ModelAttribute("pizza") Pizza formPizza, Model model) {

		if (formPizza.getNome() == null || formPizza.getDescrizione() == null || formPizza.getPrezzo() == null) {
			return "/pizza/create";
		}

		pizzaRepo.save(formPizza);

		return "redirect:/pizzeria";
	}

}
