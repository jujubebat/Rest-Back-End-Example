package com.jujubebat.dto;

import com.jujubebat.model.Product;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString(exclude = {"product"})
public class CalendarResponseDto {
    private Long userId;
    private List<Product> productList;
}

