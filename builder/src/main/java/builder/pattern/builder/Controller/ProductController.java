package builder.pattern.builder.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import builder.pattern.builder.Entities.Product;
import builder.pattern.builder.Services.ProductServiceImpl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/products")
public class ProductController {
    

    private final ProductServiceImpl serv;

    public ProductController(ProductServiceImpl service){
        this.serv = service;
    }

    @PostMapping("/process")
    public String processProducts() {
        serv.processProducts();
        
        return "Data returned sucessfully";
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return serv.showAllProducts();
    }

    @PostMapping("/build")
    public ResponseEntity<Product> buildProduct(@RequestBody Product p){
        serv.buildProduct(p);
        return ResponseEntity.status(HttpStatus.CREATED).body(p);
    }

}
