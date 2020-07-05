package com.project.CrudSpringBoot.interfaceService;

import java.util.List;
import java.util.Optional;

import com.project.CrudSpringBoot.modelo.Persona;

public interface IpersonaService {
  
   public List<Persona>listar();
   public Optional<Persona>ListarId(int id);
   public int save(Persona p);
   public void delete(int id);
}
