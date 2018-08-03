package com.nr.learning.productservice.rest;

import com.nr.learning.productservice.dto.ApiCreateProduct;
import com.nr.learning.productservice.model.Product;
import com.nr.learning.productservice.service.ProductService;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nishantr on 13/07/18.
 */
@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

  @Autowired
  private ProductService productService;

  @PostMapping
  public ResponseEntity createProduct(@RequestBody ApiCreateProduct apiCreateProduct) {
    return ResponseEntity.ok(productService.createProduct(apiCreateProduct));
  }

  @GetMapping("/{productId}")
  public ResponseEntity getProduct(@PathVariable UUID productId) {
    return ResponseEntity.ok(productService.findByProductId(productId));
  }

  @GetMapping("/sku/{sku}")
  public ResponseEntity getProductFromSku(@PathVariable String sku) throws Exception{
    log.info("getProductFromSku : " + sku);
    Product product = productService.findBySku(sku);
    return ResponseEntity.ok(productService.save(product));
  }
}
