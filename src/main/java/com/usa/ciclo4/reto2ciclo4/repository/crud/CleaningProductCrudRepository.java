package com.usa.ciclo4.reto2ciclo4.repository.crud;

import com.usa.ciclo4.reto2ciclo4.model.CleaningProduct;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CleaningProductCrudRepository extends MongoRepository<CleaningProduct, Integer>{
    
}
