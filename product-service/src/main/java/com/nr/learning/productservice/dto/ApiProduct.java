package com.nr.learning.productservice.dto;

import javax.persistence.Column;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * Created by nishantr on 13/07/18.
 */
@Data
public class ApiProduct {

  private String sku;

  private String productName;

  private Integer availableQuantity;

}
