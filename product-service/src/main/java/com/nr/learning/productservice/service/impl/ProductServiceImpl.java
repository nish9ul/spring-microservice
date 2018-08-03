package com.nr.learning.productservice.service.impl;

import com.nr.learning.productservice.dto.ApiCreateProduct;
import com.nr.learning.productservice.dto.ProductMapper;
import com.nr.learning.productservice.model.Product;
import com.nr.learning.productservice.repository.ProductRepository;
import com.nr.learning.productservice.service.ProductService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nishantr on 13/07/18.
 */
@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  ProductRepository productRepository;

  @Override
  public Product createProduct(ApiCreateProduct apiProduct) {
    return productRepository.save(ProductMapper.INTANCE.toProduct(apiProduct));
  }

  @Override
  public Product findByProductId(UUID productId) {
    return productRepository.findById(productId).get();
  }

  @Override
  public Product findBySku(String sku) {
    return productRepository.findBySku(sku);
  }

  @Override
  public Product save(Product product) {
    return productRepository.save(product);
  }

}
