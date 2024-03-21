package com.avaliacao.controlller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avaliacao.entities.ItemPedido;
import com.avaliacao.service.ItemPedidoService;

import jakarta.validation.Valid;

@RestController  
@CrossOrigin(origins= "*")  
@RequestMapping("/itemPedido") 
public class ItemPedidoController {  
	
	private final ItemPedidoService itemPedidoService; 
	
	@Autowired  
	public ItemPedidoController(ItemPedidoService itemPedidoService) {  
		this.itemPedidoService = itemPedidoService;  
	}  
	@GetMapping("/{id}")  
	public ResponseEntity<ItemPedido> buscaItemPedidoControlId(@PathVariable Long id){  
		ItemPedido itemPedido = itemPedidoService.buscaItemPedidoId(id);  
		if(itemPedido != null) {  
			return ResponseEntity.ok(itemPedido);  
		}  
		else {  
			return ResponseEntity.notFound().build();  
		}  
	}  
	@GetMapping  
	public ResponseEntity<List<ItemPedido>> buscaTodosItemPedidosControl(){  
		List<ItemPedido>ItemPedido = itemPedidoService.buscaTodosItens();  
		return ResponseEntity.ok(ItemPedido);  
	}  
	@PostMapping  
	public ResponseEntity<ItemPedido> salvaItemPedidosControl(@RequestBody @Valid ItemPedido itemPedido){ 
		ItemPedido salvaItemPedido = itemPedidoService.salvaItemPedido(itemPedido);  
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaItemPedido);  
	}  
	@PutMapping("/{id}")  
	public ResponseEntity<ItemPedido> alteraItemPedidoControl(@PathVariable Long id, @RequestBody @Valid ItemPedido itemPedido){ 
		ItemPedido alteraItemPedido = itemPedidoService.alterarItemPedido(id, itemPedido);  
		if(alteraItemPedido != null) {  
			return ResponseEntity.ok(itemPedido);  
		}  
		else {  
			return ResponseEntity.notFound().build();  
		}  
	}  
	@DeleteMapping("/{id}")  
	public ResponseEntity<ItemPedido> apagaItemPedidoControl(@PathVariable Long id){  
		boolean apagar = itemPedidoService.apagarItem(id);  
		if (apagar) {  
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  
		}  
		else {  
			return ResponseEntity.notFound().build();  
		}  
	}  
} 
