package com.nr.learning.authservice.dto;

import com.nr.learning.authservice.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * Created by nishantr on 10/07/18.
 */
@Mapper(componentModel = "spring",  nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  User toUser(ApiCreateUser apiCreateUser);

  User toUser(ApiUser apiRetailer);

  ApiUser fromUser(User user);

}
