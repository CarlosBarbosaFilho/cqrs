package br.com.cbgomes.query.repository;

import br.com.cbgomes.query.model.ProductQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductQueryRepository extends JpaRepository<ProductQuery, Long> {

}
