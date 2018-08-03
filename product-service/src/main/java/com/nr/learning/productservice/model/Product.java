package com.nr.learning.productservice.model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * Created by nishantr on 13/07/18.
 */
@Entity
@Data
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID productId;

  @Column(unique = true, length = 100, nullable = false)
  @Size(min = 8, max = 10)
  private String sku;

  @Column(length = 100, nullable = false)
  @Size(min = 1, max = 100)
  private String productName;

  @Column(nullable = false)
  private Integer availableQuantity = new Integer(0);

}
