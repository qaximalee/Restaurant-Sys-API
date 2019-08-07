package com.balti.restaurant.sys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.balti.restaurant.sys.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
