package com.unla.ApiRestVentas.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="vendedor")
@Data @NoArgsConstructor @AllArgsConstructor 
public class Vendedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idVendedor;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="dni")
	private long dni;

	@Column(name="Billetera")
	private double Billetera;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vendedor")
	private Set<Producto> productos = new HashSet<>();
	
}