package com.jujubebat.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "public_auction_num")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
