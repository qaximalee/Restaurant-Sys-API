package com.balti.restaurant.sys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.balti.restaurant.sys.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
