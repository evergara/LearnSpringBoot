package com.ecosoft.customer.customers.service;

import com.ecosoft.customer.customers.client.IUserClient;
import com.ecosoft.customer.customers.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//@Primary // para desambiguar clases con @Autowired
@Service
@Qualifier("CLOUD")
@ConditionalOnProperty(prefix = "app",name = "edition",havingValue = "Pro")
@Lazy
public class UserServiceCloudImpl implements IUserService{
    @Autowired
    IUserClient userClient;

    @Override
    public UserDTO getUserById(Integer id) {
        return userClient.getUser(id);
    }
}
