package com.ecosoft.customer.customers.client;

import com.ecosoft.customer.customers.model.UserDTO;

public interface IUserClient {
    public UserDTO getUser(Integer id);
}
