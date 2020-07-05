package com.project.CrudSpringBoot.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.CrudSpringBoot.modelo.Persona;

@Repository
public interface IPersona extends CrudRepository<Persona, Integer>{

}
