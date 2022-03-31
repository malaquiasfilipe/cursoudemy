package com.cursodespringboot.udemy.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;

import com.cursodespringboot.udemy.services.validation.ClienteInsert;


@ClienteInsert
public class ClienteNewDTO  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@javax.validation.constraints.NotEmpty(message= "Preencimento obrigatorio")
	@Length(min= 5, max= 150 , message = "O tamanho deve ser entre 5 e 120")
	private String nome;
	
	@javax.validation.constraints.NotEmpty(message= "Preenchimento Obrigatorio")
	@Email (message="Email invalido")
	private String email;
	
	@javax.validation.constraints.NotEmpty(message= "Preencimento obrigatorio")

	private String  numContribuente;
	private Integer tipo;
	

	private String bairro;
	private String municipio; 
	private String nomeRua;
	private Integer numCasa;
	
	@javax.validation.constraints.NotEmpty(message= "Preencimento obrigatorio")
	private String telefone1;
	
	private String telefone2;
	
	private String telefone3;
	
	private Integer CidadeId;
	
	private ClienteNewDTO() {
		
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

	public String getNumContribuente() {
		return numContribuente;
	}

	public void setNumContribuente(String numContribuente) {
		this.numContribuente = numContribuente;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getNomeRua() {
		return nomeRua;
	}

	public void setNomeRua(String nomeRua) {
		this.nomeRua = nomeRua;
	}

	public Integer getNumCasa() {
		return numCasa;
	}

	public void setNumCasa(Integer numCasa) {
		this.numCasa = numCasa;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}

	public Integer getCidadeId() {
		return CidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		CidadeId = cidadeId;
	}

}
