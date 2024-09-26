package com.example.clothing_store.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "color")
@Data
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "color_id")
    private int colorId;
    @Column(name = "name")
    private String name;
    @ManyToMany(fetch = FetchType.LAZY,cascade = {
            CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
    })
    @JoinTable(name = "product_color",
               joinColumns = @JoinColumn(name = "color_id"),
               inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;
}
