package com.nr.learning.orderservice.dto.remote;

import java.util.UUID;
import lombok.Data;

/**
 * Created by nishantr on 15/07/18.
 */
@Data
public class Product {

  private UUID productId;

  private String sku;

  private String productName;

  private Integer availableQuantity;
}
