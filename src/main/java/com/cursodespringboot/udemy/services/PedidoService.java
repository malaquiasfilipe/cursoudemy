package com.cursodespringboot.udemy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursodespringboot.udemy.domain.Pedido;
import com.cursodespringboot.udemy.repositories.PedidoRepository;
import com.cursodespringboot.udemy.services.exceptions.ObjectNoFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNoFoundException("Objecto não encontrado Id: " + id + ", do tipo "+ Pedido.class.getName()));
		
		
		
	}

}
