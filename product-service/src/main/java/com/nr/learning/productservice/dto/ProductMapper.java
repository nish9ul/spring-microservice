package com.nr.learning.productservice.dto;

import com.nr.learning.productservice.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * Created by nishantr on 13/07/18.
 */
@Mapper(componentModel = "spring",  nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

  ProductMapper INTANCE = Mappers.getMapper(ProductMapper.class);

  Product toProduct(ApiCreateProduct apiProduct);

  ApiProduct fromProduct(Product user);
}