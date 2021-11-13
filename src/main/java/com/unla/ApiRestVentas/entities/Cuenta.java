package com.unla.ApiRestVentas.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cuenta")
@Data@AllArgsConstructor  @NoArgsConstructor @Builder
public class Cuenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCuenta;
	
	@Column(name="nroCuenta")
	private int nroCuenta;
	
	@Column(name="monto")
	private double monto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="vendedor_id", nullable=false)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Vendedor vendedor;
	
}