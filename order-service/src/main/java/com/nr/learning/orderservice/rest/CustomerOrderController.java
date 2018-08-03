package com.nr.learning.orderservice.rest;

import com.nr.learning.orderservice.client.ProductServiceClient;
import com.nr.learning.orderservice.dto.ApiCreateCustomerOrder;
import com.nr.learning.orderservice.dto.ApiCustomerOrder;
import com.nr.learning.orderservice.dto.ApiCustomerOrderStatus;
import com.nr.learning.orderservice.dto.CustomerOrderMapper;
import com.nr.learning.orderservice.dto.remote.Product;
import com.nr.learning.orderservice.model.OrderStatus;
import com.nr.learning.orderservice.service.CustomerOrderService;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nishantr on 12/07/18.
 */
@RestController
@Slf4j
@RequestMapping("/order")
public class CustomerOrderController {

  @Autowired
  private CustomerOrderService customerOrderService;

  @Autowired
  ProductServiceClient productServiceClient;

  @PostMapping
  public ResponseEntity<ApiCustomerOrder> createOrder(@RequestBody ApiCreateCustomerOrder createCustomerOrder){
    createCustomerOrder.setOrderStatus(OrderStatus.CANCELLED);
    try{
      Product product =  productServiceClient.getProductFromSku(createCustomerOrder.getSku());
      log.info("Got product: " + product);
      if(product != null && product.getAvailableQuantity() > 0) {
        createCustomerOrder.setOrderStatus(OrderStatus.PLACED);
      }
    } catch (Exception e ){
      log.error("Error while getting order",e);
    }
    return ResponseEntity.ok(CustomerOrderMapper.INSTANCE.fromCustomerOrder(customerOrderService.save(createCustomerOrder)));
  }

  @GetMapping("/status/{customerOrderId}")
  public ResponseEntity<ApiCustomerOrderStatus> getOrderStatus(@PathVariable UUID customerOrderId){
    return ResponseEntity.ok(CustomerOrderMapper.INSTANCE.fromCustomerOrderToStatus(customerOrderService.findOrder(customerOrderId)));
  }

}
