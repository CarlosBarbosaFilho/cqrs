package br.com.cbgomes.command.service;

import br.com.cbgomes.command.external.ProductEvent;
import br.com.cbgomes.command.model.Product;
import br.com.cbgomes.command.repository.ProductCommandRepository;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ProductCommandService {

    private final ProductCommandRepository repository;
    private final KafkaTemplate<String, ProductEvent> kafkaTemplate;

    public void createProduct(Product product){
        var productEvent = ProductEvent.builder()
                .product(product)
                .event_type("create_product")
                .build();
        this.repository.save(productEvent.getProduct());
        kafkaTemplate.send("products_topics", productEvent );
        this.repository.save(product);
    }
}
