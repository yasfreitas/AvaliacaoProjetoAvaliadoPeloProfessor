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

import com.avaliacao.entities.Pedido;
import com.avaliacao.service.PedidoService;

import jakarta.validation.Valid;

@RestController  
@CrossOrigin(origins= "*")  
@RequestMapping("/pedido")  
public class PedidoController {  
	
	private final PedidoService pedidoService; 
	
	@Autowired  
	public PedidoController(PedidoService pedidoService) {  
		this.pedidoService = pedidoService;  
	}  
	@GetMapping("/{id}")  
	public ResponseEntity<Pedido> buscaPedidoControlId(@PathVariable Long id){  
		Pedido pedido = pedidoService.buscaPedidoId(id);  
		if(pedido != null) {  
			return ResponseEntity.ok(pedido);  
		}  
		else {  
			return ResponseEntity.notFound().build();  
		}  
	}  
	@GetMapping  
	public ResponseEntity<List<Pedido>> buscaTodosPedidosControl(){  
		List<Pedido>Pedido = pedidoService.buscaTodosPedidos();  
		return ResponseEntity.ok(Pedido);  
	}  
	@PostMapping  
	public ResponseEntity<Pedido> salvaPedidosControl(@RequestBody @Valid Pedido pedido){  
		Pedido salvaPedido = pedidoService.salvaPedido(pedido);  
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaPedido);  
	}  
	@PutMapping("/{id}")  
	public ResponseEntity<Pedido> alteraPedidoControl(@PathVariable Long id, @RequestBody @Valid Pedido pedido){ 
		Pedido alteraPedido = pedidoService.alterarPedido(id, pedido);  
		if(alteraPedido != null) {  
			return ResponseEntity.ok(pedido);  
		}  
		else {  
			return ResponseEntity.notFound().build();  
		}  
	}  
	@DeleteMapping("/{id}")  
	public ResponseEntity<Pedido> apagaPedidoControl(@PathVariable Long id){  
		boolean apagar = pedidoService.apagarPedido(id);  
		if (apagar) {  
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  
		} 
		else { 
			return ResponseEntity.notFound().build();  
		}  
	}  
} 
