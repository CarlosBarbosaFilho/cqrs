package br.com.cbgomes.command.controller;

import br.com.cbgomes.command.controller.request.ProductRequest;
import br.com.cbgomes.command.mapper.ConverterDTO;
import br.com.cbgomes.command.model.Product;
import br.com.cbgomes.command.service.ProductCommandService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/command/products")
@RestController
@AllArgsConstructor
public class ProductCommandController {

    private final ProductCommandService service;
    private final ConverterDTO converter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> create(@RequestBody ProductRequest request) {
        this.service.createProduct((Product) converter.convertObject(request, Product.class));
        return ResponseEntity.status(201).build();
    }
}
