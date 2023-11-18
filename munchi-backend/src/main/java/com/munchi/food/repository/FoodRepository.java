package com.munchi.food.repository;

import com.munchi.food.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Integer> {
    
}
