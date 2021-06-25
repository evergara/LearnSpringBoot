package com.ecosoft.customer.customers.service;

import com.ecosoft.customer.customers.model.UserDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier("BD")
@ConditionalOnProperty(prefix = "app",name = "edition",havingValue = "community")
@Lazy
public class UserServiceImpl implements IUserService{

    @Override
    public UserDTO getUserById(Integer id) {
        return new UserDTO(1,"Emerson", "admin","admin");
    }
}
