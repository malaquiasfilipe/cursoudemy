package com.cursodespringboot.udemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cursodespringboot.udemy.domain.Categoria;
import com.cursodespringboot.udemy.domain.Cliente;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	
	//@Transactional(readOnly = true)
	//Cliente findByEmail(String email);
	
}
 