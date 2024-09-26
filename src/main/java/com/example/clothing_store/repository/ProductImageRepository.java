package com.example.clothing_store.repository;

import com.example.clothing_store.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "product-image")
public interface ProductImageRepository extends JpaRepository<ProductImage,Integer> {
}
