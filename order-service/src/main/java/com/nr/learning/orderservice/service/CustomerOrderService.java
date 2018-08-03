package com.nr.learning.orderservice.service;

import com.nr.learning.orderservice.dto.ApiCreateCustomerOrder;
import com.nr.learning.orderservice.model.CustomerOrder;
import java.util.UUID;

/**
 * Created by nishantr on 12/07/18.
 */
public interface CustomerOrderService {

  CustomerOrder save(ApiCreateCustomerOrder apiUser);

  CustomerOrder findOrder(UUID customerOrderId);

}
