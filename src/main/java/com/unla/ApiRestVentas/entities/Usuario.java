package com.unla.ApiRestVentas.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @Getter @Setter private Long id;
    @Getter @Setter private String nombre;
    @Getter @Setter private String apellido;
    @Getter @Setter private String email;
    @Getter @Setter private String password;
    @Getter @Setter private long dni;
    @Getter @Setter private String rol;
    
    @OneToOne
    @JoinColumn(name = "FK_VENDEDOR")
	@Getter @Setter private Vendedor vendedor;


}