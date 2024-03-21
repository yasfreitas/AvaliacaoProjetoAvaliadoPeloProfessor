package com.avaliacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacao.entities.ItemPedido;
import com.avaliacao.repository.ItemPedidoRepository;


@Service
public class ItemPedidoService {

	private final ItemPedidoRepository itemPedidoRepository;

	@Autowired
	public ItemPedidoService(ItemPedidoRepository itemPedidoRepository) {
		this.itemPedidoRepository = itemPedidoRepository;
	}
	public List<ItemPedido> buscaTodosItens(){
		return itemPedidoRepository.findAll();
	}
	public ItemPedido buscaItemPedidoId(Long id) {
		Optional <ItemPedido> ItemPedido = itemPedidoRepository.findById(id);
		return ItemPedido.orElse(null);
	}
	public ItemPedido salvaItemPedido(ItemPedido itemPedido) {
		return itemPedidoRepository.save(itemPedido);
	}
	public ItemPedido alterarItemPedido( Long id, ItemPedido alterarItem) {
		Optional<ItemPedido> existeItem = itemPedidoRepository.findById(id);
		if(existeItem.isPresent()) {
			alterarItem.setId(id);
			return itemPedidoRepository.save(alterarItem);
		}
		return null;
	}
	public boolean apagarItem(Long id) {
		Optional<ItemPedido> existeItem = itemPedidoRepository.findById(id);
		if(existeItem.isPresent()) {
			itemPedidoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
