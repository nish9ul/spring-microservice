package com.nr.learning.orderservice.dto;

import com.nr.learning.orderservice.model.CustomerOrder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * Created by nishantr on 12/07/18.
 */
@Mapper(componentModel = "spring",  nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerOrderMapper {

  CustomerOrderMapper INSTANCE = Mappers.getMapper(CustomerOrderMapper.class);

  CustomerOrder toCustomerOrder(ApiCreateCustomerOrder customerOrder);

  ApiCustomerOrder fromCustomerOrder(CustomerOrder user);

  ApiCustomerOrderStatus fromCustomerOrderToStatus(CustomerOrder user);

}
