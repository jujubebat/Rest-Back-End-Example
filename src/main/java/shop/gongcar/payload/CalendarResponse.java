package shop.gongcar.payload;

import shop.gongcar.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CalendarResponse {

    private Long userId;
    private List<Product> productList;

}


