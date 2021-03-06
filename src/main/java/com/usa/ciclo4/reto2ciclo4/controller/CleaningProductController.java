package com.usa.ciclo4.reto2ciclo4.controller;

import java.util.List;
import java.util.Optional;

import com.usa.ciclo4.reto2ciclo4.model.CleaningProduct;
import com.usa.ciclo4.reto2ciclo4.service.CleaningProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cleaningprod")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CleaningProductController {
    @Autowired
    private CleaningProductService cleaningProductService;

    @GetMapping("/all")
    public List<CleaningProduct> getAll(){
        return cleaningProductService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<CleaningProduct> getCleaningProduct(@PathVariable("id") Integer id) {
        return cleaningProductService.getCleaningProduct(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody CleaningProduct cleaningproduct){
        cleaningProductService.save(cleaningproduct);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public CleaningProduct update(@RequestBody CleaningProduct cleaningproduct){
        return cleaningProductService.update(cleaningproduct);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return cleaningProductService.delete(id);
    }

    @GetMapping("/price/{price}")
    public List<CleaningProduct> getByPrice(@PathVariable("price") double price){
        return cleaningProductService.getByPrice(price);
    }

    @GetMapping("/description/{description}")
    public List<CleaningProduct> getByDescriptionContains(@PathVariable("description") String description){
        return cleaningProductService.getByDescriptionContains(description);
    }
}
