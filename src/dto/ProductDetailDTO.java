package dto;

import model.Product;
import model.ProductOption;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailDTO {
    private int productId;
    private List<ProductOptionDTO> productOptions = new ArrayList<ProductOptionDTO>();

    public ProductDetailDTO(Product product, List<ProductOption> productOptions) {
        this.productId = product.getId();
        for (ProductOption productOption : productOptions) {
            this.productOptions.add(new ProductOptionDTO(productOption));
        }

    }

    class ProductOptionDTO {
        private int optionId;
        private String optionName;
        private int price;
        private int qty;

        public ProductOptionDTO(ProductOption option) {
            this.optionId = option.getId();
            this.optionName = option.getName();
            this.price = option.getPrice();
            this.qty = option.getQty();
        }

        public int getOptionId() {
            return optionId;
        }

        public void setOptionId(int optionId) {
            this.optionId = optionId;
        }

        public String getOptionName() {
            return optionName;
        }

        public void setOptionName(String optionName) {
            this.optionName = optionName;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getQty() {
            return qty;
        }

        public void setQty(int qty) {
            this.qty = qty;
        }
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public List<ProductOptionDTO> getProductOptions() {
        return productOptions;
    }

    public void setProductOptions(List<ProductOptionDTO> productOptions) {
        this.productOptions = productOptions;
    }
}
