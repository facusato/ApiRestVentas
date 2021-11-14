package com.unla.ApiRestVentas.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.ApiRestVentas.entities.Producto;
import com.unla.ApiRestVentas.entities.Vendedor;

@Repository("productoRepository")
public interface IProductoRepository extends JpaRepository<Producto,Serializable> {
	
	public abstract Producto findByIdProducto(long idProducto);
	
	public abstract Producto findByNombre(String nombre);
	
	public List<Producto> findByVendedor(Vendedor vendedor);
	
	
	

}