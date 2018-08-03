package com.nr.learning.orderservice.client;

import com.nr.learning.orderservice.dto.remote.Product;
import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by nishantr on 15/07/18.
 */
@FeignClient("product-service")
public interface ProductServiceClient {

  @GetMapping("/product/{productId}")
  Product getProduct(@PathVariable UUID productId);

  @GetMapping("/product/sku/{sku}")
  Product getProductFromSku(@PathVariable String sku);

}
