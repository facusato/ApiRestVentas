package com.unla.ApiRestVentas.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UsuarioVendedorDTO {
	
	@Getter @Setter private String email;
    @Getter @Setter private String password;
    @Getter @Setter private String rol;
    @Getter @Setter private String nombre;
    @Getter @Setter private String apellido;
    @Getter @Setter private long dni;
    @Getter @Setter private String domicilio;

}