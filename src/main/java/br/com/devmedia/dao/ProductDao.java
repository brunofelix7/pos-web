package br.com.devmedia.dao;

import java.util.List;
import br.com.devmedia.domain.Product;

public interface ProductDao {

	void save(Product product);
    List<Product> list();
    Product findById(Long id);
    void update(Product product);
    void delete(Long id);
	
}
