package com.example.clothing_store.repository;

import com.example.clothing_store.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "size")
public interface SizeRepository extends JpaRepository<Role,Integer> {
}
