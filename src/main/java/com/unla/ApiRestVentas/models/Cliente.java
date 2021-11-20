package com.unla.ApiRestVentas.models;


import lombok.Data;


@Data
public class Cliente {
	
	private long idCliente;
	private String nombre;
	private String apellido;	
	private long dni;

}
