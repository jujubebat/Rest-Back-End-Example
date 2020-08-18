package com.jujubebat.dto;

import com.jujubebat.model.Product;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = {"product"})
public class CalendarResponseDto {
    //private Long publicAuctionNum;
    private Product product;
    private Long userId;
}

