package com.unla.ApiRestVentas.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.ApiRestVentas.entities.Cuenta;
import com.unla.ApiRestVentas.entities.Vendedor;

@Repository("cuentaRepository")
public interface ICuentaRepository extends JpaRepository<Cuenta,Serializable> {
	
	public abstract Cuenta findByIdCuenta(long idCuenta);
	
	public List<Cuenta> findByVendedor(Vendedor vendedor);
	
	
}