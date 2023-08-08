package br.com.cbgomes.query.service;

import br.com.cbgomes.query.external.ProductEvent;
import br.com.cbgomes.query.mapper.ConverterDTO;
import br.com.cbgomes.query.model.ProductQuery;
import br.com.cbgomes.query.repository.ProductQueryRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductQueryService {

    private final ProductQueryRepository repository;
    private final ConverterDTO converter;


    public List<ProductQuery> list() {
        return this.repository.findAll();
    }

    @KafkaListener(topics = "products_topics", groupId = "products-group")
    public void processEvents(String event) {
        System.out.println("Getting event" + event);
        ProductEvent productEvent = null;
        try {
            productEvent = new ObjectMapper().readValue(event, ProductEvent.class);
            System.out.println("Getting event" + productEvent);
            switch (productEvent.getEvent_type()) {
                case "create_product" -> this.repository.save(productEvent.getProduct());
                case "update_product" -> System.out.println("update product");
                case "delete_product" -> System.out.println("delete product");
                default -> {
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
