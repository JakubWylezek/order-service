package com.foodorder.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TableService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${table_service.port}")
    private String TABLE_SERVICE_PORT;

    @Value("${table_service.url}")
    private String TABLE_SERVICE_URL;

    public Boolean checkIfTableExist(int number) {
        return restTemplate.getForObject(
                TABLE_SERVICE_PORT + TABLE_SERVICE_URL + "tables/" + number, Boolean.class);
    }
}
