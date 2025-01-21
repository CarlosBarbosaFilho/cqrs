package br.com.cbgomes.query.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product-query")
public class ProductQuery {

    @Id
    @JsonIgnoreProperties
    private Long id;
    private String name;
    private String code;
    private String category;
    private BigDecimal price;
}
