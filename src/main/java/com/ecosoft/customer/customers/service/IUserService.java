package com.ecosoft.customer.customers.service;

import com.ecosoft.customer.customers.model.UserDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    public UserDTO getUserById(Integer id);
    /**
    public Optional<UserDTO> getUserById(Integer id);

    public List<UserDTO> listAllUsers(Pageable pageable);

    public UserDTO saveUser(UserDTO userDTO);

    public void deleteById(Integer id);
    **/

}
