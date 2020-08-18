package shop.gongdal.dto;

import shop.gongdal.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CalendarResponseDto {

    private Long userId;
    private List<Product> productList;

}


