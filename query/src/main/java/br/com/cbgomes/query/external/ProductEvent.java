package br.com.cbgomes.query.external;

import br.com.cbgomes.query.model.ProductQuery;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductEvent {

    private String event_type;
    private ProductQuery product;
}
