package com.example.clothing_store.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "size")
@Data
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "size_id")
    private int sizeId;
    @JoinColumn(name = "name")
    private String name;
    @ManyToMany(fetch = FetchType.LAZY,cascade = {
            CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
    })
    @JoinTable(name = "product_size",
               joinColumns = @JoinColumn(name = "size_id"),
               inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;
}
