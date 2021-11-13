package com.unla.ApiRestVentas.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.ApiRestVentas.entities.Cuenta;
import com.unla.ApiRestVentas.entities.Vendedor;
import com.unla.ApiRestVentas.repositories.ICuentaRepository;
import com.unla.ApiRestVentas.services.ICuentaService;

@Service("cuentaService")
public class CuentaService implements ICuentaService {
	
	@Autowired
	@Qualifier("cuentaRepository")
	private ICuentaRepository cuentaRepository;
	
	@Override
	public List<Cuenta> getAll() {
		return cuentaRepository.findAll();
	}

	@Override
	public Cuenta findByIdCuenta(long idCuenta) {
		
		return cuentaRepository.findByIdCuenta(idCuenta);
	}

	@Override
	public Cuenta insert(Cuenta cuenta) {
		return cuentaRepository.save(cuenta);
	}

	@Override
	public Cuenta update(Cuenta cuenta) {
		Cuenta c = cuentaRepository.findByIdCuenta(cuenta.getIdCuenta());
        if (null == c){
            return null;
        }
      
        return cuentaRepository.save(c);
	}

	@Override
	public boolean remove(long idCuenta) {
		try {
			cuentaRepository.deleteById(idCuenta);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Cuenta> findByVendedor(Vendedor vendedor) {
		return cuentaRepository.findByVendedor(vendedor);
	}
}
