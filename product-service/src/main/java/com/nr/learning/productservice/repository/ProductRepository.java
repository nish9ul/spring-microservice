package com.nr.learning.productservice.repository;

import com.nr.learning.productservice.model.Product;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nishantr on 13/07/18.
 */
public interface ProductRepository extends JpaRepository<Product, UUID> {

  Product findBySku(String sku);
}
