package com.cursodespringboot.udemy.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursodespringboot.udemy.domain.ItemPedido;
import com.cursodespringboot.udemy.domain.PagamentoComBoleto;
import com.cursodespringboot.udemy.domain.Pedido;
import com.cursodespringboot.udemy.domain.enums.EstadoPagamento;
import com.cursodespringboot.udemy.repositories.ItemPedidoRepository;
import com.cursodespringboot.udemy.repositories.PagamentoRepository;
import com.cursodespringboot.udemy.repositories.PedidoRepository;
import com.cursodespringboot.udemy.repositories.ProdutoRepository;
import com.cursodespringboot.udemy.services.exceptions.ObjectNoFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNoFoundException("Objecto não encontrado Id: " + id + ", do tipo "+ Pedido.class.getName()));
			
		
	}
	
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if(obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
		obj= repo.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		for(ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setPreco(produtoRepository.findById(ip.getProduto().getId()));
			ip.setPedido(obj);
				
		}
		itemPedidoRepository.saveAll(obj.getItens());
		return obj;
	}

}
