package br.com.cbgomes.command.repository;

import br.com.cbgomes.command.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCommandRepository extends JpaRepository<Product, Long> {
}
