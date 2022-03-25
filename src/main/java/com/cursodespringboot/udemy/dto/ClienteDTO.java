package com.cursodespringboot.udemy.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;

import com.cursodespringboot.udemy.domain.Cliente;

public class ClienteDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@javax.validation.constraints.NotEmpty(message= "Preenchimento Obrigatorio")
	@Length(min = 5, max = 120 ,message ="O tamanho deve ser ser entre 5 a 120 caracteres")
	private String nome;
	
	@javax.validation.constraints.NotEmpty (message = "Preenhimento Obrigatorio")
	@Email(message = " Email invalido")
	private String email;
	
	public ClienteDTO() {
		
	}

	public ClienteDTO(Cliente obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
		
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
