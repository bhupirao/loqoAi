package com.loqoai.Repository;

import com.loqoai.Model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {


//     Custom query method to find products based on multiple criteria.
//
//      @param category  The category to filter by.
//      @param minPrice  The minimum price to filter by.
//      @param maxPrice  The maximum price to filter by.
//      @param inStock   The stock availability to filter by.
//      @param pageable  Pagination and sorting information.
//      @return A list of products that match the criteria.

    @Query("SELECT p FROM Product p WHERE (:category IS NULL OR p.category = :category) " +
            "AND (:minPrice IS NULL OR p.price >= :minPrice) " +
            "AND (:maxPrice IS NULL OR p.price <= :maxPrice) " +
            "AND (:inStock IS NULL OR p.inStock = :inStock)")
    List<Product> findProducts(
            @Param("category") String category,
            @Param("minPrice") Double minPrice,
            @Param("maxPrice") Double maxPrice,
            @Param("inStock") Boolean inStock,
            Pageable pageable);
}
