package com.usa.ciclo4.reto2ciclo4.repository.crud;

import java.util.List;

import com.usa.ciclo4.reto2ciclo4.model.Order;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderCrudRepository extends MongoRepository<Order, Integer>{
    List<Order> findBySalesManZone(String zone);  
}
