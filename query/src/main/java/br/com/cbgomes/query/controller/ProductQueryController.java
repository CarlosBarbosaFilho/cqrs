package br.com.cbgomes.query.controller;

import br.com.cbgomes.query.controller.response.ProductResponse;
import br.com.cbgomes.query.mapper.ConverterDTO;
import br.com.cbgomes.query.service.ProductQueryService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/query/products")
public class ProductQueryController {
    private final ProductQueryService service;
    private final ConverterDTO converter;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ProductResponse>> list(){
        var products = this.service.list();
        var response = (List<ProductResponse>) converter.convertListObjects(products, ProductResponse.class);
        return ResponseEntity.ok(response);
    }
}
