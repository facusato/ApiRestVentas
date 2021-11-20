package com.unla.ApiRestVentas.services.implementation;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.ApiRestVentas.repositories.IProductoRepository;
import com.unla.ApiRestVentas.repositories.IVendedorRepository;
import com.unla.ApiRestVentas.services.IVendedorService;
import com.unla.ApiRestVentas.entities.Producto;
import com.unla.ApiRestVentas.entities.Vendedor;

@Service("vendedorService")
public class VendedorService implements IVendedorService {
	
	@Autowired
	@Qualifier("vendedorRepository")
	private IVendedorRepository vendedorRepository;
	
	@Autowired
	@Qualifier("productoRepository")
	private IProductoRepository productoRepository;
	
	@Override
	public List<Vendedor> getAll() {
		return vendedorRepository.findAll();
	}

	@Override
	public Vendedor findByIdVendedor(long idVendedor) {
		
		return vendedorRepository.findByIdVendedor(idVendedor);
	}

	@Override
	public Vendedor insert(Vendedor vendedor) {
		return vendedorRepository.save(vendedor);
	}

	@Override
	public Vendedor update(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
	}

	@Override
	public boolean remove(long idVendedor) {
		try {
			vendedorRepository.deleteById(idVendedor);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	 public ArrayList<Vendedor>  obtenerProductosPorVendedor(long id) {
	        return vendedorRepository.findByProductos_idProducto(id);
	 }
	 
	    //Distintos
	 public ArrayList<Vendedor>  obtenerPorNombreProducto(String nombre) {
	    	
	    	
	        return vendedorRepository.findDistinctByProductos_nombre(nombre);
	  }
	   
	 @Transactional
	 public Vendedor addProducts(Vendedor vendedor, Producto producto) {
	    	
	    	return vendedorRepository.save(vendedor);
	    }

}
