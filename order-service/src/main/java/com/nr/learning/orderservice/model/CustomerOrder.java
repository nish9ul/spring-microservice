package com.nr.learning.orderservice.model;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 * Created by nishantr on 12/07/18.
 */
@Entity
@Data
public class CustomerOrder {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID customerOrderId;

  private String sku;

  private Integer quantity;

  private Date orderDate = new Date();

  private Long orderAmount;

  private UUID customerId;

  @Enumerated(EnumType.STRING)
  private OrderStatus orderStatus = OrderStatus.PLACED;

}
