package com.nr.learning.orderservice.repository;

import com.nr.learning.orderservice.model.CustomerOrder;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nishantr on 12/07/18.
 */
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, UUID> {

  CustomerOrder findByCustomerOrderId(UUID customerOrderId);
}
