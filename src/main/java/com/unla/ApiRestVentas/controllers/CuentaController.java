package com.unla.ApiRestVentas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unla.ApiRestVentas.entities.Cuenta;
import com.unla.ApiRestVentas.entities.Vendedor;
import com.unla.ApiRestVentas.services.implementation.CuentaService;
import com.unla.ApiRestVentas.services.implementation.VendedorService;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {
	
	@Autowired
	@Qualifier("cuentaService")
	CuentaService cuentaService;
	
	@Autowired
	@Qualifier("vendedorService")
	VendedorService vendedorService;
	
	
	@GetMapping()
	public ResponseEntity<List<Cuenta>> obtenerCuentas(){
		
		List<Cuenta> cuentas=cuentaService.getAll();
		if(cuentas.isEmpty()) {
			ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(cuentas);
	}
	
	@GetMapping("/{idCuenta}")
	public ResponseEntity<Cuenta> obtenerCuentaPorId(@PathVariable("idCuenta") long idCuenta){
		
		Cuenta c=cuentaService.findByIdCuenta(idCuenta);
		if(c==null) {
			ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(c);
	}
	
	 @PostMapping()
	 public ResponseEntity<Cuenta> insertarCuenta( @RequestBody Cuenta cuenta, BindingResult result){
	       
	        return ResponseEntity.status(HttpStatus.CREATED).body(cuentaService.insert(cuenta));
	 }
	 
	 @PutMapping("/{idCuenta}")
	    public ResponseEntity<Cuenta> actualizarCuenta(@PathVariable("idCuenta") Long idCuenta, @RequestBody Cuenta cuenta){
		 	Cuenta cuentaActualizada= cuentaService.findByIdCuenta(idCuenta);
		 	cuentaActualizada.setNroCuenta(cuenta.getNroCuenta());
	        cuentaActualizada.setMonto(cuenta.getMonto());
	        Vendedor vendedorActualizado= vendedorService.findByIdVendedor(cuenta.getVendedor().getIdVendedor());
	        vendedorActualizado.setNombre(cuenta.getVendedor().getNombre());
	        vendedorActualizado.setUsuario(cuenta.getVendedor().getUsuario());
	        vendedorActualizado.setPassword(cuenta.getVendedor().getPassword());
	        vendedorActualizado.setApellido(cuenta.getVendedor().getApellido());
	        vendedorActualizado.setDni(cuenta.getVendedor().getDni());
	        vendedorActualizado.setBilletera(cuenta.getVendedor().getBilletera());
	        vendedorService.update(vendedorActualizado);
	        cuentaActualizada.setVendedor(vendedorActualizado);
	        return ResponseEntity.ok(cuentaService.update(cuentaActualizada));
	    }
	 
	 
	 @DeleteMapping("/{idCuenta}")
		public boolean borrarCuenta(@PathVariable("idCuenta") long idCuenta) {
			return cuentaService.remove(idCuenta);
		}
}
