package com.jujubebat.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // https://delf-lee.github.io/post/detached-entity-passed-to-persist-error/
    // https://conservative-vector.tistory.com/entry/%EC%98%A4%EB%A5%98
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn
    private Product product;

    private String imgUrl;
}
