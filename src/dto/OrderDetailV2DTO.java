package dto;

import lombok.Data;
import model.OrderOption;

import java.util.*;
import java.util.stream.Collectors;

@Data
public class OrderDetailV2DTO {
    private int orderId;
    private List<ProductDTO> products;
    private int sumPrice;

    public OrderDetailV2DTO(List<OrderOption> orderOptions) {
        this.orderId = orderOptions.get(0).getId();
        this.products = orderOptions.stream()
                .collect(Collectors.groupingBy(option -> option.getProduct().getId())) // productId로 그룹화
                .entrySet().stream()
                .map(entry -> new ProductDTO(entry.getKey(), entry.getValue())) // ProductDTO로 변환
                .toList();
        this.sumPrice = orderOptions.stream().mapToInt(option -> option.getTotalPrice()).sum();
    }

    @Data
    class ProductDTO {
        private int productId;
        private List<OrderOptionDTO> orderOptions;

        public ProductDTO(int productId, List<OrderOption> orderOptions) {
            this.productId = productId;
            this.orderOptions = orderOptions.stream().map(option -> new OrderOptionDTO(option)).toList();
        }

        @Data
        class OrderOptionDTO {
            private int orderOptionId;
            private String orderOptionName;
            private int orderQty;
            private int orderTotalPrice;

            public OrderOptionDTO(OrderOption orderOption) {
                this.orderOptionId = orderOption.getId();
                this.orderOptionName = orderOption.getOptionName();
                this.orderQty = orderOption.getQty();
                this.orderTotalPrice = orderOption.getTotalPrice();
            }
        }
    }
}
