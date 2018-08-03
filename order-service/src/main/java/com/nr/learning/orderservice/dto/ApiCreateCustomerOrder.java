package com.nr.learning.orderservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nr.learning.orderservice.model.OrderStatus;
import java.util.UUID;
import lombok.Data;

/**
 * Created by nishantr on 12/07/18.
 */
@Data
public class ApiCreateCustomerOrder {

  private String sku;

  private Integer quantity;

  private Long orderAmount;

  private UUID customerId;

  @JsonIgnore
  private OrderStatus orderStatus;

}
