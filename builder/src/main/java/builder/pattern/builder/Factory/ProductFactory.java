package builder.pattern.builder.Factory;

import org.springframework.stereotype.Component;

import builder.pattern.builder.Entities.Product;

@Component
public class ProductFactory {
    

    public Product createProduct(Long id, String n, Double p, String c){
        return new Product.ProductBuilder()
        .id(id)
        .name(n)
        .price(p)
        .category(c)
        .build();
    }
    
}
