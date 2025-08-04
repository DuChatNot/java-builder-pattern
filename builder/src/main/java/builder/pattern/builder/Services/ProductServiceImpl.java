package builder.pattern.builder.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import builder.pattern.builder.DAO.ProductDAO;
import builder.pattern.builder.Entities.Product;
import builder.pattern.builder.Factory.ProductFactory;

@Service
public class ProductServiceImpl {
    
    private ProductDAO dao;
    private ProductFactory factory;

    public ProductServiceImpl(ProductDAO dao, ProductFactory factory){
        this.dao = dao;
        this.factory = factory;
    }


    public void processProducts(){

        String[][] data = {
            {"1", "Laptop", "1200", "Electronics"},
            {"2", "Phone", "800", "Electronics"},
            {"3", "Desk", "200", "Furniture"}
        };

        for(String[] row: data){
            Long id = Long.parseLong(row[0]);
            String name = row[1];
            Double price = Double.parseDouble(row[2]);
            String category = row[3];
            
            
            Product p = factory.createProduct(id, name, price, category);
            dao.save(p);
        }

    }

    public List<Product> showAllProducts(){

        List<Product> prods = dao.findAll();
        
        System.out.println("=== Product List ===");
        for(Product p: prods){
            System.out.println(p);
        }
        return prods;
    }

    public void buildProduct(Product p){
        Product prod = factory.createProduct(p.getId(), p.getName(), p.getPrice(), p.getCategory());
        dao.save(prod);
    }
}
