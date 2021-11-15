package com.unla.ApiRestVentas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.unla.ApiRestVentas.entities.Vendedor;
import com.unla.ApiRestVentas.services.implementation.VendedorService;



@RestController
@RequestMapping("/vendedor")
public class VendedorController {
	
	@Autowired
	@Qualifier("vendedorService")
	VendedorService vendedorService;
	
	
	@GetMapping()
	public ResponseEntity<List<Vendedor>> obtenerVendedores(){
		
		List<Vendedor> vendedores=vendedorService.getAll();
		if(vendedores.isEmpty()) {
			ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(vendedores);
	}
	
	@GetMapping("/{idVendedor}")
	public ResponseEntity<Vendedor> obtenerVendedorPorId(@PathVariable("idVendedor") long idVendedor){
		
		Vendedor v=vendedorService.findByIdVendedor(idVendedor);
		if(v==null) {
			ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(v);
	}
	
	 @PostMapping()
	 public ResponseEntity<Vendedor> insertarVendedor( @RequestBody Vendedor vendedor, BindingResult result){
	       
	        return ResponseEntity.status(HttpStatus.CREATED).body(vendedorService.insert(vendedor));
	 }
	 
	 @PutMapping("/{idVendedor}")
	    public ResponseEntity<Vendedor> actualizarVendedor(@PathVariable("idVendedor") Long idVendedor, @RequestBody Vendedor vendedor){
		 	Vendedor vendedorActualizado= vendedorService.findByIdVendedor(idVendedor);
	        vendedorActualizado.setUsuario(vendedor.getUsuario());
	        vendedorActualizado.setPassword(vendedor.getPassword());
	        vendedorActualizado.setNombre(vendedor.getNombre());
	        vendedorActualizado.setApellido(vendedor.getApellido());
	        vendedorActualizado.setDni(vendedor.getDni());
	        vendedorActualizado.setBilletera(vendedor.getBilletera());
	        return ResponseEntity.ok(vendedorService.update(vendedorActualizado));
	    }
	 
	 
	 @DeleteMapping("/{idVendedor}")
		public boolean borrarVendedor(@PathVariable("idVendedor") long idVendedor) {
			return vendedorService.remove(idVendedor);
		}
	 
	 

}
