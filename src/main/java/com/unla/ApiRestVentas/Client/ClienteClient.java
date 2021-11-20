package com.unla.ApiRestVentas.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.ApiRestVentas.models.Cliente;

@FeignClient(name="RestApiCompra")
@RequestMapping("/cliente")
public interface ClienteClient {
	
	@PostMapping()
	public ResponseEntity<Cliente> insertarCliente(@RequestBody Cliente cliente);

}
