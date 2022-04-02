package com.cursodespringboot.udemy;


import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cursodespringboot.udemy.domain.Categoria;
import com.cursodespringboot.udemy.domain.Cidade;
import com.cursodespringboot.udemy.domain.Cliente;
import com.cursodespringboot.udemy.domain.Endereco;
import com.cursodespringboot.udemy.domain.Estado;
import com.cursodespringboot.udemy.domain.ItemPedido;
import com.cursodespringboot.udemy.domain.Pagamento;
import com.cursodespringboot.udemy.domain.PagamentoComBoleto;
import com.cursodespringboot.udemy.domain.PagamentoComCartao;
import com.cursodespringboot.udemy.domain.Pedido;
import com.cursodespringboot.udemy.domain.Produto;
import com.cursodespringboot.udemy.domain.enums.EstadoPagamento;
import com.cursodespringboot.udemy.domain.enums.TipoCliente;
import com.cursodespringboot.udemy.repositories.CategoriaRepository;
import com.cursodespringboot.udemy.repositories.CidadeRepository;
import com.cursodespringboot.udemy.repositories.ClienteRepository;
import com.cursodespringboot.udemy.repositories.EnderecoRepository;
import com.cursodespringboot.udemy.repositories.EstadoRepository;
import com.cursodespringboot.udemy.repositories.ItemPedidoRepository;
import com.cursodespringboot.udemy.repositories.PagamentoRepository;
import com.cursodespringboot.udemy.repositories.PedidoRepository;
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
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(UdemyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		Categoria cat3 = new Categoria (null, "Mobilias");
		Categoria cat4 = new Categoria (null, "Electronicos");
		Categoria cat5 = new Categoria (null, "Jardinagem");
		Categoria cat6 = new Categoria (null, " Decoração");
		Categoria cat7 = new Categoria (null, "Perfumaria");
		
		Produto p1 = new Produto(null, "Computador", 2200.00);
		Produto p2 = new Produto (null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 50.00);
		Produto p4 = new Produto(null, "Mesa de Escritorio", 300.00);
		Produto p5 = new Produto(null, "Toalha", 50.00);
		Produto p6 = new Produto(null, "Colha", 300.00);
		Produto p7 = new Produto(null, "TV true color", 1200.00);
		Produto p8 = new Produto(null, "Roçadeira", 800.00);
		Produto p9 = new Produto(null, "Abajour", 100.00);
		Produto p10 = new Produto(null, "Pendente",180.00);
		Produto p11 = new Produto(null, "Shampoo", 90.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		cat2.getProdutos().addAll(Arrays.asList(p2,p4));
		cat3.getProdutos().addAll(Arrays.asList(p5,p6));
		cat4.getProdutos().addAll(Arrays.asList(p1,p2,p3,p7));
		cat5.getProdutos().addAll(Arrays.asList(p8));
		cat6.getProdutos().addAll(Arrays.asList(p9,p10));
		cat7.getProdutos().addAll(Arrays.asList(p11));
		
		p1.getCategorias().addAll(Arrays.asList(cat1,cat4));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2,cat4));
		p3.getCategorias().addAll(Arrays.asList(cat1,cat4));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		p7.getCategorias().addAll(Arrays.asList(cat4));
		p8.getCategorias().addAll(Arrays.asList(cat5));
		p9.getCategorias().addAll(Arrays.asList(cat6));
		p10.getCategorias().addAll(Arrays.asList(cat6));
		p11.getCategorias().addAll(Arrays.asList(cat7));
		
				
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5,cat6,cat7));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11));
		
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			
		Pedido ped1 = new Pedido(null, sdf.parse("14/03/2021 12:15"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("05/04/2021 13:23"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/04/2021 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
	}

	

}
