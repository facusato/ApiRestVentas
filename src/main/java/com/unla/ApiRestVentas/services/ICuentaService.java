package com.unla.ApiRestVentas.services;

import java.util.List;

import com.unla.ApiRestVentas.entities.Cuenta;
import com.unla.ApiRestVentas.entities.Vendedor;

public interface ICuentaService {
	
	public List<Cuenta> getAll();
    
    public List<Cuenta> findByVendedor(Vendedor vendedor);
	
	public Cuenta findByIdCuenta(long idCuenta);
	
	public Cuenta insert(Cuenta cuenta);
	
	public Cuenta update(Cuenta cuenta);
	
	public boolean remove(long idCuenta);

}
