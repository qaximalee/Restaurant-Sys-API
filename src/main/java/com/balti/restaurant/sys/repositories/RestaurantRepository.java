package com.balti.restaurant.sys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.balti.restaurant.sys.entities.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{

}
