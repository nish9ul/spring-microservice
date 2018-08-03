package com.nr.learning.orderservice.dto;

import com.nr.learning.orderservice.model.OrderStatus;
import java.util.UUID;
import lombok.Data;

/**
 * Created by nishantr on 12/07/18.
 */
@Data
public class ApiCustomerOrder {

  private UUID customerOrderId;

  private UUID customerId;

  private OrderStatus orderStatus;

}
