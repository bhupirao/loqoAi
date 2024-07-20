package com.loqoai;

import com.loqoai.Model.Product;
import com.loqoai.Repository.ProductRepo;
import com.loqoai.Service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepo productRepo;

    @InjectMocks
    private ProductService productService;

    private Product product1;
    private Product product2;

    @BeforeEach
    void setUp() {
        product1 = new Product(1, "Product1", "Category1", 10.0, true, 4.5, new Date());
        product2 = new Product(2, "Product2", "Category2", 20.0, false, 3.5, new Date());
    }

    @Test
    void testAddProduct() {
        when(productRepo.save(any(Product.class))).thenReturn(product1);
        Product result = productService.addProduct(product1);
        assertEquals(product1, result);
    }

    @Test
    void testGetProducts() {
        List<Product> productList = Arrays.asList(product1, product2);
        Pageable pageable = PageRequest.of(0, Integer.MAX_VALUE, Sort.by(Sort.Direction.ASC, "id"));
        when(productRepo.findProducts(anyString(), anyDouble(), anyDouble(), anyBoolean(), eq(pageable)))
                .thenReturn(productList);

        List<Product> result = productService.getProducts("Category1", 10.0, 30.0, true, "id", "asc");
        assertEquals(productList, result);
    }
}
