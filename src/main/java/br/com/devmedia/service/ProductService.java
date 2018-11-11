package br.com.devmedia.service;

import java.util.List;
import br.com.devmedia.domain.Product;

public interface ProductService {

    void save(Product product);
    List<Product> list();
    Product findById(Long id);
    void update(Product product);
    void delete(Long id);

}
