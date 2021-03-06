package com.cursodespringboot.udemy.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.cursodespringboot.udemy.domain.Cliente;
import com.cursodespringboot.udemy.domain.enums.TipoCliente;
import com.cursodespringboot.udemy.dto.ClienteNewDTO;
import com.cursodespringboot.udemy.repositories.ClienteRepository;
import com.cursodespringboot.udemy.resources.exceptions.FieldMessage;
import com.cursodespringboot.udemy.services.validation.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	
	@Autowired
	private ClienteRepository repo;
	
	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();

		if(objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getNumContribuente())) {
			list.add(new FieldMessage("numContribuente", "Numero de Contribuente Invalido"));
		}
		
		if(objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getNumContribuente())) {
			list.add(new FieldMessage("numContribuente", "Numero de Contribuente Invalido"));
		}
		
		Cliente aux = repo.findByEmail(objDto.getEmail());
		if (aux!= null) {
			list.add(new FieldMessage("email", "email ja existente")) ;
		}
		
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldname())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
