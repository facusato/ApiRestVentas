package com.unla.ApiRestVentas.repositories;

import java.io.Serializable;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.ApiRestVentas.entities.Producto;
import com.unla.ApiRestVentas.entities.Vendedor;


@Repository("productoRepository")
public interface IProductoRepository extends JpaRepository<Producto,Serializable> {
	
	public abstract Producto findByIdProducto(long idProducto);
	
	public abstract List<Producto> findByVendedor(Vendedor vendedor);
	
	@Query("SELECT p FROM  Producto p WHERE p.nombre = (:nombre)")
	public abstract List<Producto> findByNombre(String nombre);
	
	@Query("SELECT p FROM Producto p JOIN FETCH p.vendedor v WHERE v.idVendedor= (:idVendedor)")
	public abstract List<Producto> findByIdVendedor(long idVendedor);

}