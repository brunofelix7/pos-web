package br.com.devmedia.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.devmedia.domain.Product;

@Repository
public class ProductDaoImpl implements ProductDao{

	@PersistenceContext
    private EntityManager em;

    @Override
    public void save(Product product) {
        em.persist(product);
    }

    @Override
    public List<Product> list() {
        return em.createQuery("select p from Product p", Product.class).getResultList();
    }

    @Override
    public Product findById(Long id) {
        return em.find(Product.class, id);
    }

    @Override
    public void update(Product product) {
        em.merge(product);
    }

    @Override
    public void delete(Long id) {
        em.remove(em.getReference(Product.class, id));
    }
	
}
