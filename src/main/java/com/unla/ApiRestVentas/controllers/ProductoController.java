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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unla.ApiRestVentas.entities.Producto;
import com.unla.ApiRestVentas.entities.Vendedor;
import com.unla.ApiRestVentas.services.implementation.ProductoService;
import com.unla.ApiRestVentas.services.implementation.VendedorService;


@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	@Qualifier("productoService")
	ProductoService productoService;
	
	@Autowired
	@Qualifier("vendedorService")
	VendedorService vendedorService;
	
	
	@GetMapping()
	public ResponseEntity<List<Producto>> obtenerProductos(){
		
		List<Producto> productos=productoService.getAll();
		if(productos.isEmpty()) {
			ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(productos);
	}
	
	@GetMapping("/{idProducto}")
	public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable("idProducto") long idProducto){
		
		Producto v=productoService.findByIdProducto(idProducto);
		if(v==null) {
			ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(v);
	}
	
	
	@GetMapping("/vendedor/{idVendedor}")
	public ResponseEntity<List<Producto>> obtenerProductoPorIdVendedor(@PathVariable("idVendedor") long idVendedor){
		
		List<Producto> p=productoService.findByIdVendedor(idVendedor);
		if(p.isEmpty()) {
			ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(p);
	}
	
	@GetMapping("/nombre/{nombre}")
	public ResponseEntity<List<Producto>> obtenerProductosPorNombre(@PathVariable("nombre") String nombre){
		
		List<Producto> v=productoService.findByNombre(nombre);
		if(v.isEmpty()) {
			ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(v);
	}
	
	 @PostMapping()
	 public ResponseEntity<Producto> insertarProducto( @RequestBody Producto producto, BindingResult result){
	       
	        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.insert(producto));
	 }
	 
	 @PutMapping("/{idProducto}")
	    public ResponseEntity<Producto> actualizarProducto(@PathVariable("idProducto") Long idProducto, @RequestBody Producto producto){
		 	Producto productoActualizado= productoService.findByIdProducto(idProducto);
	        productoActualizado.setNombre(producto.getNombre()); 
	        productoActualizado.setDescripcion(producto.getDescripcion());
	        productoActualizado.setImagen(producto.getImagen());
	        productoActualizado.setPrecio(producto.getPrecio());
	        productoActualizado.setStock(producto.getStock());
	        productoActualizado.setFormaDePago(producto.getFormaDePago());
	        Vendedor vendedorActualizado= vendedorService.findByIdVendedor(producto.getVendedor().getIdVendedor());
	        vendedorActualizado.setNombre(producto.getVendedor().getNombre());
	        vendedorActualizado.setUsuario(producto.getVendedor().getUsuario());
	        vendedorActualizado.setPassword(producto.getVendedor().getPassword());
	        vendedorActualizado.setApellido(producto.getVendedor().getApellido());
	        vendedorActualizado.setDni(producto.getVendedor().getDni());
	        vendedorActualizado.setBilletera(producto.getVendedor().getBilletera());
	        vendedorService.update(vendedorActualizado);
	        productoActualizado.setVendedor(vendedorActualizado);
	        return ResponseEntity.ok(productoService.update(productoActualizado));
	    }
	 
	 
	 @DeleteMapping("/{idProducto}")
		public boolean borrarProducto(@PathVariable("idProducto") long idProducto) {
			return productoService.remove(idProducto);
		}
	 
	 
	 @PutMapping ("/stock/{idProducto}")
	    public ResponseEntity<Producto> updateStockProduct(@PathVariable("idProducto")  Long idProducto ,@RequestParam(name = "stock", required = true) int stock){
	        Producto p = productoService.updateStock(idProducto, stock);
	        if (p == null){
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok(p);
	    }
	 

}
