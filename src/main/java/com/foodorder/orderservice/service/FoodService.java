package com.foodorder.orderservice.service;

import com.foodorder.orderservice.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FoodService {

    @Value("${food_service.port}")
    private String FOOD_SERVICE_PORT;

    @Value("${food_service.url}")
    private String FOOD_SERVICE_URL;

    @Autowired
    private RestTemplate restTemplate;

    public Food getFoodByName(String name) {
        return restTemplate.getForObject(
                FOOD_SERVICE_URL + FOOD_SERVICE_PORT + "/foods/" + name, Food.class);
    }
}
