package com.unla.ApiRestVentas.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.ApiRestVentas.entities.Producto;
import com.unla.ApiRestVentas.entities.Vendedor;
import com.unla.ApiRestVentas.repositories.IProductoRepository;
import com.unla.ApiRestVentas.services.IProductoService;

@Service("productoService")
public class ProductoService implements IProductoService {
	
	@Autowired
	@Qualifier("productoRepository")
	private IProductoRepository productoRepository;
	
	@Override
	public List<Producto> getAll() {
		return productoRepository.findAll();
	}

	@Override
	public Producto findByIdProducto(long idProducto) {
		
		return productoRepository.findByIdProducto(idProducto);
	}

	@Override
	public Producto insert(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public Producto update(Producto producto) {
		Producto p = productoRepository.findByIdProducto(producto.getIdProducto());
        if (null == p){
            return null;
        }
      
        return productoRepository.save(p);
	}

	@Override
	public boolean remove(long idProducto) {
		try {
			productoRepository.deleteById(idProducto);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Producto> findByVendedor(Vendedor vendedor) {
		return productoRepository.findByVendedor(vendedor);
	}

	@Override
	public Producto updateStock(Long idProducto, int cantidad) {
		Producto p = productoRepository.findByIdProducto(idProducto);
        if (null == p){
            return null;
        }
        int stockActualizado =  p.getStock() + cantidad;
        p.setStock(stockActualizado);
        return productoRepository.save(p);
    }
	

}