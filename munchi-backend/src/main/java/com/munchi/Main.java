package com.munchi;

import com.munchi.food.model.Food;
import com.munchi.food.repository.FoodRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/food")
public class Main {

    private final FoodRepository foodRepository;
    
    public Main(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping
    public List<Food> getFood() {
        return foodRepository.findAll();
    }


    record NewFoodRequest(
        String name,
        Double price,
        String category,
        String restaurant
    ) {

    }
    @PostMapping
    public void addFood(@RequestBody NewFoodRequest request) {
        Food food = new Food();
        food.setName(request.name());
        food.setPrice(request.price());
        food.setCategory(request.category());
        food.setRestaurant(request.restaurant());
        foodRepository.save(food);
    }

    @DeleteMapping("{foodId}")
    public void deleteFood(@PathVariable("foodId") Integer id) {
        foodRepository.deleteById(id);
    }
}
