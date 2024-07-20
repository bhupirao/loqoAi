package com.loqoai.Service;

import com.loqoai.Model.Product;
import com.loqoai.Repository.ProductRepo;
import jakarta.persistence.PrePersist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @PrePersist
    public  Product addProduct(Product product){
        // add product to call productRepo and save
        return productRepo.save(product);
    }


    public List<Product> getProducts(String category, Double minPrice, Double maxPrice, Boolean inStock,
                                     String sortField, String sortOrder) {

        // Determine the sort direction and field
        Sort.Direction direction = "desc".equalsIgnoreCase(sortOrder) ? Sort.Direction.DESC : Sort.Direction.ASC;
        Sort sort = Sort.by(direction, sortField != null ? sortField : "id");

        // Create a Pageable object with the sort configuration
        Pageable pageable = PageRequest.of(0, Integer.MAX_VALUE, sort);

        // Call the repository method with pagination and sorting
        return productRepo.findProducts(category, minPrice, maxPrice, inStock, pageable);

    }



}
