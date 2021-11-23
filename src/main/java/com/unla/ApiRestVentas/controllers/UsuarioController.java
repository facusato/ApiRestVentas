package com.unla.ApiRestVentas.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unla.ApiRestVentas.Client.ClienteClient;
import com.unla.ApiRestVentas.entities.Usuario;
import com.unla.ApiRestVentas.entities.Vendedor;
import com.unla.ApiRestVentas.models.Cliente;
import com.unla.ApiRestVentas.models.UsuarioVendedorDTO;
import com.unla.ApiRestVentas.services.implementation.UsuarioService;
import com.unla.ApiRestVentas.services.implementation.VendedorService;



@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	VendedorService vendedorService;
	
	@Autowired
	ClienteClient clienteClient;

	@GetMapping()
	public ArrayList<Usuario> obtenerUsuarios() {
		return usuarioService.obtenerUsuarios();
	}

	@PostMapping()
	public Usuario guardarUsuario(@RequestBody Usuario usuario) {
		return this.usuarioService.guardarUsuario(usuario);
	}

	@GetMapping(path = "/{id}")
	public Optional<Usuario> obtenerUsuarioPorId(@PathVariable("id") Long id) {
		return this.usuarioService.obtenerPorId(id);
	}

	@DeleteMapping(path = "/{id}")
	public String eliminarPorId(@PathVariable("id") Long id) {
		boolean ok = this.usuarioService.eliminarUsuario(id);
		if (ok) {
			return "Se eliminó el usuario con id " + id;
		} else {
			return "No pudo eliminar el usuario con id" + id;
		}
	}

	@GetMapping("/login") 
	public ResponseEntity<Vendedor> obtenerUsuarioPorEmail(@RequestParam("name") String email) {
		Vendedor v = null;
		try {

			Usuario user = this.usuarioService.obtenerPorEmail(email).get();
			if (user.getEmail().equals(email))
				v = this.vendedorService.findByIdVendedor(user.getId());
		} catch (Exception e) {
			System.out.println("System Error: " + e.getMessage());
		}
		return ResponseEntity.ok(v);
	}

	@PostMapping("/login")
	public Optional<Usuario> autenticarUsuario(@RequestBody Usuario request) {
		Optional<Usuario> response = Optional.empty(); // responder json null o json con todos los atributos en null?
		Usuario user = null;
		try {
			Optional<Usuario> userEmail = this.usuarioService.obtenerPorEmail(request.getEmail());	
			if (userEmail.isPresent()) {
				user = userEmail.get();
				if (user.getPassword().equals(request.getPassword())) {
					response = userEmail;
				}					
			}
		} catch (Exception e) {
			System.out.println("System Error: " + e.getMessage());
		}
			
		return response;
	}
	
	
	@PostMapping(path = "/save")
    public Usuario createUsuario(@RequestBody UsuarioVendedorDTO dto) {
		Usuario u = new Usuario();
		if (dto.getRol().equals("vendedor")){
			Vendedor vendedor = new Vendedor();
	    	vendedor.setNombre(dto.getNombre());
	    	vendedor.setApellido(dto.getApellido());
	    	vendedor.setDni(dto.getDni());
	        Vendedor v= vendedorService.insert(vendedor);
	        u.setVendedor(v);
		}
		//implementar un rol cliente
		else {
			Cliente cliente =new Cliente();
			cliente.setNombre(dto.getNombre());
			cliente.setApellido(dto.getApellido());
	    	cliente.setDni(dto.getDni());
	    	cliente.setDomicilio(dto.getDomicilio());
	    	clienteClient.insertarCliente(cliente);
		}
        u.setNombre(dto.getNombre());
        u.setApellido(dto.getApellido());
        u.setDni(dto.getDni());
    	u.setEmail(dto.getEmail());
    	u.setPassword(dto.getPassword());
    	u.setRol(dto.getRol());
    	
    	return usuarioService.guardarUsuario(u); 
	}

}