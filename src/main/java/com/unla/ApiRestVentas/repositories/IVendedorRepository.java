package com.unla.ApiRestVentas.repositories;

import java.io.Serializable;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unla.ApiRestVentas.entities.Vendedor;



@Repository("vendedorRepository")
public interface IVendedorRepository extends JpaRepository<Vendedor,Serializable> {
	
	public abstract Vendedor findByIdVendedor(long idVendedor);
	

}
