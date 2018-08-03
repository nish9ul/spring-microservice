package com.nr.learning.orderservice.service.impl;


import com.nr.learning.orderservice.dto.ApiCreateCustomerOrder;
import com.nr.learning.orderservice.dto.CustomerOrderMapper;
import com.nr.learning.orderservice.model.CustomerOrder;
import com.nr.learning.orderservice.repository.CustomerOrderRepository;
import com.nr.learning.orderservice.service.CustomerOrderService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nishantr on 12/07/18.
 */
@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

  @Autowired
  private CustomerOrderRepository customerOrderRepository;

  @Override
  public CustomerOrder save(ApiCreateCustomerOrder customerOrder) {
    return customerOrderRepository.save(CustomerOrderMapper.INSTANCE.toCustomerOrder(customerOrder));
  }

  @Override
  public CustomerOrder findOrder(UUID customerOrderId) {
     return customerOrderRepository.findById(customerOrderId).get();
  }
}
