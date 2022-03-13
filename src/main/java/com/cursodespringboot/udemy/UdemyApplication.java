package com.cursodespringboot.udemy;


import java.util.Arrays;

import org.apache.tomcat.util.digester.ArrayStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cursodespringboot.udemy.domain.Categoria;
import com.cursodespringboot.udemy.domain.Cidade;
import com.cursodespringboot.udemy.domain.Cliente;
import com.cursodespringboot.udemy.domain.Endereco;
import com.cursodespringboot.udemy.domain.Estado;
import com.cursodespringboot.udemy.domain.Produto;
import com.cursodespringboot.udemy.domain.enums.TipoCliente;
import com.cursodespringboot.udemy.repositories.CategoriaRepository;
import com.cursodespringboot.udemy.repositories.CidadeRepository;
import com.cursodespringboot.udemy.repositories.ClienteRepository;
import com.cursodespringboot.udemy.repositories.EnderecoRepository;
import com.cursodespringboot.udemy.repositories.EstadoRepository;
import com.cursodespringboot.udemy.repositories.ProdutoRepository;

@SpringBootApplication
public class UdemyApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(UdemyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null, "Computador", 2200.00);
		Produto p2 = new Produto (null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 50.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat2));
		
				
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado (null, "LUANDA");
		Estado est2 = new Estado (null, "UIGE");
		
		Cidade c1 = new Cidade (null, "Viana-Zango", est1);
		Cidade c2 = new Cidade (null, "Negage", est2);
		Cidade c3 = new Cidade (null, "Cacuaco", est1);
		
		est1.getCidades().addAll(Arrays.asList(c1,c3));
		est2.getCidades().addAll(Arrays.asList(c2));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente( null, "Veni", "veni@gmail.com", "AO00654LA040", TipoCliente.PESSOAFISICA );
		cli1.getTelefones().addAll(Arrays.asList("+244945855658 ", "+244993455788"));
		
		Endereco e1 = new Endereco(null, "Zango", "Viana", "Rua da Dira", 110, cli1, c1);
		Endereco e2 = new Endereco(null, "Benfica", "Negage", "Lavra Street", 0254, cli1, c2);
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
			
	}

	

}
