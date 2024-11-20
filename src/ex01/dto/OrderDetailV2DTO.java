package ex01.dto;

import ex01.model.OrderOption;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class OrderDetailV2DTO {
    private int orderId;
    private List<OrderProductDTO> products;
    private int sumPrice;

    public OrderDetailV2DTO(List<OrderOption> options) {
        // 1. orderId
        this.orderId = options.get(0).getOrder().getId();

        // 2. sumPrice
        this.sumPrice = options.stream()
                .mapToInt(value -> value.getTotalPrice())
                .sum();

        // 3. products
        // 3.1 List<OrderOption> options 친구를 물가에 던진다
        // 3.2 productId로 그룹핑 (or1, or2) (or3)
        // 3.3 OrderProductDTO를 그룹 개수만큼 생성해서 만들어주기

        this.products = options.stream()
                .collect(Collectors.groupingBy(op ->op.getProduct().getId()))
                .entrySet() // Map타입을 set타입으로 변경 (다시 stream 돌리려고 - 컬렉션만 stream 가능)
                .stream()
                .map(en -> new OrderProductDTO(en.getValue())) // 2바퀴
                .toList();
    }

    @Data
    class OrderProductDTO { // 돈봉투
        private int productId;
        private List<OrderOptionDTO> options = new ArrayList<>();

        public OrderProductDTO(List<OrderOption> options) {
            this.productId = options.get(0).getProduct().getId();
            this.options = options.stream()
                    .map(orderOption -> new OrderOptionDTO(orderOption))
                    .toList();
        }

        @Data
        class OrderOptionDTO{
            private int id;
            private String optionName;
            private int qty;
            private int totalPrice;

            public OrderOptionDTO(OrderOption option) {
                this.id = option.getId();
                this.optionName = option.getOptionName();
                this.qty = option.getQty();
                this.totalPrice = option.getTotalPrice();
            }
        }
    }
}
