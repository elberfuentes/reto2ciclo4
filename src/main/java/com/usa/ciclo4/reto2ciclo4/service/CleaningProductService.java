package com.usa.ciclo4.reto2ciclo4.service;

import java.util.List;
import java.util.Optional;
import com.usa.ciclo4.reto2ciclo4.model.CleaningProduct;
import com.usa.ciclo4.reto2ciclo4.repository.CleaningProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CleaningProductService {
    @Autowired
    private CleaningProductRepository cleaningProductRepository;

    public List<CleaningProduct> getAll(){
        return cleaningProductRepository.getAll();
    }

    public Optional<CleaningProduct> getCleaningProduct(int id){
        return cleaningProductRepository.getCleaningProduct(id);
    }

    public CleaningProduct save(CleaningProduct cleaningproduct){
        if (cleaningproduct.getId()== null){
            return cleaningproduct;
        }
        return cleaningProductRepository.save(cleaningproduct);
    }

    public CleaningProduct update(CleaningProduct cleaningproduct){
        if (cleaningproduct.getId()!= null){
            Optional<CleaningProduct> dbProduct = cleaningProductRepository.getCleaningProduct(cleaningproduct.getId());
            if (!dbProduct.isEmpty()){
                if (cleaningproduct.getBrand()!= null){
                    dbProduct.get().setBrand(cleaningproduct.getBrand());
                }
                if (cleaningproduct.getCategory()!= null){
                    dbProduct.get().setCategory(cleaningproduct.getCategory());
                }
                if (cleaningproduct.getPresentation()!= null){
                    dbProduct.get().setPresentation(cleaningproduct.getPresentation());
                }
                if (cleaningproduct.getDescription() != null){
                    dbProduct.get().setDescription(cleaningproduct.getDescription());
                }
                if (cleaningproduct.getPrice()!= 0.0){
                    dbProduct.get().setPrice(cleaningproduct.getPrice());
                }

                dbProduct.get().setAvailability(cleaningproduct.isAvailability());

                
                if (cleaningproduct.getQuantity()!= 0){
                    dbProduct.get().setQuantity(cleaningproduct.getQuantity());
                }
                if (cleaningproduct.getPhotography()!= null){
                    dbProduct.get().setPhotography(cleaningproduct.getPhotography());
                }
                cleaningProductRepository.update(dbProduct.get());
                return dbProduct.get();
            } else {
                return cleaningproduct;
            }
        } else {
            return cleaningproduct;
        }
    }

    public boolean delete(int id){
        return getCleaningProduct(id).map(cleaningproduct -> {
            cleaningProductRepository.delete(cleaningproduct);
            return true;
        }).orElse(false);
    }
}
