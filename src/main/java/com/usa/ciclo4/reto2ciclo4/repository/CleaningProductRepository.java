package com.usa.ciclo4.reto2ciclo4.repository;

import java.util.List;
import java.util.Optional;

import com.usa.ciclo4.reto2ciclo4.model.CleaningProduct;
import com.usa.ciclo4.reto2ciclo4.repository.crud.CleaningProductCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CleaningProductRepository {
@Autowired
private CleaningProductCrudRepository cleaningProductCrudRepository;

public List<CleaningProduct> getAll(){
    return cleaningProductCrudRepository.findAll();
}

public Optional<CleaningProduct> getCleaningProduct(int id) {
    return cleaningProductCrudRepository.findById(id);
}

public CleaningProduct save(CleaningProduct cleaningproduct){
    return cleaningProductCrudRepository.save(cleaningproduct);
}

public void update(CleaningProduct cleaningproduct){
    cleaningProductCrudRepository.save(cleaningproduct);
}

public void delete(CleaningProduct cleaningproduct){
    cleaningProductCrudRepository.delete(cleaningproduct);
}

public List<CleaningProduct> getByPrice(double price){
    return cleaningProductCrudRepository.findByPrice(price);
}

public List<CleaningProduct> getByDescriptionContains(String description){
    return cleaningProductCrudRepository.findByDescriptionContainingIgnoreCase(description);
}
}
