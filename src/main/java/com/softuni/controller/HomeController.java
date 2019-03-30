package com.softuni.controller;

import com.softuni.entity.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("operator", "+");
		model.addAttribute("view", "views/calculatorForm");
		return "base-layout";
	}

	@PostMapping("/")
	public String calculate(@RequestParam String leftOperand,
							@RequestParam String operator,
							@RequestParam String rightOperand,
							Model model) {

		Calculator calculator = new Calculator(getDouble(leftOperand), getDouble(rightOperand), operator);

		model.addAttribute("leftOperand", calculator.getLeftOperand());
		model.addAttribute("operator", calculator.getOperator());
		model.addAttribute("rightOperand", calculator.getRightOperand());
		model.addAttribute("result", calculator.calculateResult());

		model.addAttribute("view", "views/calculatorForm");
		return "base-layout";
	}

	private double getDouble(String input) {
		try {
			return Double.parseDouble(input); }
		catch (NumberFormatException ex) {
			return 0;
		}
	}
}
