package com.unla.ApiRestVentas.repositories;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.ApiRestVentas.entities.Vendedor;



@Repository("vendedorRepository")
public interface IVendedorRepository extends JpaRepository<Vendedor,Serializable> {
	
	public abstract Vendedor findByIdVendedor(long idVendedor);
	
	public ArrayList<Vendedor> findByProductos_idProducto(long id);

	public ArrayList<Vendedor> findByProductos_nombre(String nombre);
	
	public ArrayList<Vendedor> findDistinctByProductos_nombre(String nombre);
	
}
