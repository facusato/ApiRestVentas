package com.unla.ApiRestVentas.services;

import java.util.List;

import com.unla.ApiRestVentas.entities.Vendedor;

public interface IVendedorService {
	
	public List<Vendedor> getAll();
	
	public Vendedor findByIdVendedor(long idVendedor);
	
	public Vendedor insert(Vendedor vendedor);
	
	public Vendedor update(Vendedor vendedor);
	
	public boolean remove(long idVendedor);

}
