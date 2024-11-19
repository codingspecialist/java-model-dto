package dto;

import model.Product;

public class ProductListDTO {
    private int id;
    private String name;

    public ProductListDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
