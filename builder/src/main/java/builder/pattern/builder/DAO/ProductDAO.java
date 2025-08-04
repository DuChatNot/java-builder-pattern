package builder.pattern.builder.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import builder.pattern.builder.Entities.Product;

@Repository
public class ProductDAO {
    
    private List<Product> products = new ArrayList<>();

    public ProductDAO(){}

    public void save(Product p){
        products.add(p);
    }

    public List<Product> findAll(){
        return products;
    }
}
