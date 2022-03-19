package com.cursodespringboot.udemy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.cursodespringboot.udemy.domain.Categoria;
import com.cursodespringboot.udemy.repositories.CategoriaRepository;
import com.cursodespringboot.udemy.services.exceptions.ObjectNoFoundException;
import com.cursodespringboot.udemy.services.exceptions.DataIntegrityException;


@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNoFoundException("Objecto não encontrado Id: " + id + ", do tipo "+ Categoria.class.getName()));
		
		
		
	}
	
	

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return  repo.save(obj);
	}
	public Categoria update (Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excmuir uma categoria que contém produtos");
			
			
		}
	}
}
