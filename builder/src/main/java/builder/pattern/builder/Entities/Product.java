package builder.pattern.builder.Entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class Product {
    
    @NotNull(message = "ID cannot be null")
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotNull(message = "Price cannot be empty")
    @Positive(message = "Price must be > 0")
    private Double price;

    @NotBlank(message = "Category cannot be empty")
    private String category;

    public Product(){}

    public Product(ProductBuilder builder){
        this.id = builder.idBuild;
        this.name = builder.nameBuild;
        this.price = builder.priceBuild;
        this.category = builder.categoryBuild;
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + "]";
    }
    
    
    public static class ProductBuilder {

        private Long idBuild;
        private String nameBuild;
        private Double priceBuild;
        private String categoryBuild;


        // Builder setters

        public ProductBuilder id(Long id){
            this.idBuild = id;
            return this;
        }

        public ProductBuilder name(String name){
            this.nameBuild = name;
            return this;
        }

        public ProductBuilder price(Double price){
            this.priceBuild = price;
            return this;
        }

        public ProductBuilder category(String category){
            this.categoryBuild = category;
            return this;
        }

        public Product build(){
            return new Product(this);
        }
    }
    
}
