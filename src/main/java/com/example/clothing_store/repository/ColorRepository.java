package com.example.clothing_store.repository;

import com.example.clothing_store.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "color")
public interface ColorRepository extends JpaRepository<Color,Integer> {
}
