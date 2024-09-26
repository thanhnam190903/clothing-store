package com.example.clothing_store.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "image_path",columnDefinition = "LONGTEXT")
    @Lob
    private String imagePath;
    @Column(name = "price")
    private double price;
    @Column(name = "original_price")
    private double originalPrice;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "description",columnDefinition = "TEXT")
    private String description;
    @Column(name = "status")
    private boolean status;
    @ManyToOne(cascade = {
            CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
    })
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;
    @ManyToMany(fetch = FetchType.LAZY,cascade = {
            CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
    })
    @JoinTable(name = "product_size",
               joinColumns = @JoinColumn(name = "product_id"),
               inverseJoinColumns = @JoinColumn(name = "size_id")
    )
    private List<Size> sizes;
    @ManyToMany(fetch = FetchType.LAZY,cascade = {
            CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
    })
    @JoinTable(name = "product_color",
               joinColumns = @JoinColumn(name = "product_id"),
               inverseJoinColumns = @JoinColumn(name = "color_id")
    )
    private List<Color> colors;
    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<ProductImage> productImages;


}
