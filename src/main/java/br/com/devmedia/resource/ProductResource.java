package br.com.devmedia.resource;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.com.devmedia.domain.Product;
import br.com.devmedia.repository.ProductRepository;

@RestController
@RequestMapping(path = "/api/products")
public class ProductResource {

	@Autowired
	ProductRepository repository;
	
	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody Product product) {
		Product personSave = repository.save(product);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getId()).toUri();
		return ResponseEntity.created(uri).body(personSave);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @Valid @RequestBody Product product) {
		product.setId(id);
		product = repository.save(product);
		return ResponseEntity.accepted().body(product);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		repository.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Product> find(@PathVariable(value = "id") Long id) {
		Product product = repository.findOne(id);
		return ResponseEntity.ok().body(product);
	}

	@GetMapping
	public ResponseEntity<List<Product>> list() {
		List<Product> products = repository.findAll();
		return ResponseEntity.ok().body(products);
	}
	
}
