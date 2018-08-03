package com.nr.learning.productservice.service;

import com.nr.learning.productservice.dto.ApiCreateProduct;
import com.nr.learning.productservice.model.Product;
import java.util.UUID;

/**
 * Created by nishantr on 13/07/18.
 */
public interface ProductService {

  Product createProduct(ApiCreateProduct apiProduct);

  Product findByProductId(UUID productId);

  Product findBySku(String sku);

  Product save(Product product);

}
