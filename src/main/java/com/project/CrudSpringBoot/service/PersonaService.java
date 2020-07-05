package com.project.CrudSpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.CrudSpringBoot.interfaceService.IpersonaService;
import com.project.CrudSpringBoot.interfaces.IPersona;
import com.project.CrudSpringBoot.modelo.Persona;

@Service
public class PersonaService implements IpersonaService {
    
 	@Autowired
	private IPersona data;
	
	@Override
	// listando dados do banco de dados 
	public List<Persona> listar() {
		return (List<Persona>)data.findAll();
	}

	@Override
	public Optional<Persona> ListarId(int id) {
		return data.findById(id);
		
	}

	@Override
	public int save(Persona p) {
		int res = 0;
		Persona persona = data.save(p);
		
		 if(!persona.equals(null)) {
			res = 1;  
		  }
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
		
	}

}
