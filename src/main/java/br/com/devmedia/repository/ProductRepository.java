package br.com.devmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.devmedia.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
