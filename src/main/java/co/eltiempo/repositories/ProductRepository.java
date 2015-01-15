package co.eltiempo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import co.eltiempo.domain.Product;

@Transactional
public interface ProductRepository extends CrudRepository<Product, Long> {

}
