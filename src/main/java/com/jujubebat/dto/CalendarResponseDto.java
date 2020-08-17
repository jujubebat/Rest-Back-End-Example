package com.jujubebat.dto;

import com.jujubebat.model.Product;
import lombok.Data;

@Data
public class CalendarResponseDto {
    //private Long publicAuctionNum;
    private Product product;
    private Long userId;
}

