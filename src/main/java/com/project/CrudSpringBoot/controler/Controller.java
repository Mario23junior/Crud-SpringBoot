package com.project.CrudSpringBoot.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.CrudSpringBoot.interfaceService.IpersonaService;
import com.project.CrudSpringBoot.modelo.Persona;

@org.springframework.stereotype.Controller
@RequestMapping
public class Controller {
	
    @Autowired
	private IpersonaService service;
	
	// listando dados do banco de dados 
	@GetMapping("/listar")
	public String listar(Model model) {
		 List<Persona> personas = service.listar();
		 model.addAttribute("personas", personas);
	     return "HomeList/index";	
	}
	
	// Renderizando formulario de cadastro
	@GetMapping("/new")
	public String inserir(Model model) {
		model.addAttribute("persona", new Persona());
		return "Form/form";
	}
	
	// salvando dados no banco de dados 
	@PostMapping("/save")
	public String save(Persona p,  Model model) {
		service.save(p);
		return "redirect:/listar";
	}
	
	// Atualizando dados
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id,  Model model) {
		Optional<Persona>persona = service.ListarId(id);
		model.addAttribute("persona",persona);
		return "Form/form";
	}
	
	// deletando dados do banco de dados
	@GetMapping("/eliminar/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/listar";
	}
}















