package br.com.devmedia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.devmedia.dao.ProductDao;
import br.com.devmedia.domain.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao dao;

    @Override
    public void save(Product product) {
        dao.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> list() {
        return dao.list();
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public void update(Product product) {
        dao.update(product);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

}

