package br.com.cbgomes.command.external;

import br.com.cbgomes.command.model.Product;
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
    private Product product;
}
