package com.ecosoft.customer.customers.service;

import com.ecosoft.customer.customers.model.UserDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier("BD")
@ConditionalOnProperty(prefix = "app",name = "edition",havingValue = "community")
@Lazy
public class UserServiceImpl implements IUserService{

    @Override
    public Optional<UserDTO> getUserById(Integer id) {
        UserDTO userDTO = new UserDTO(1,"Emerson", "admin","admin");
        return Optional.ofNullable(userDTO);
    }

    @Override
    public List<UserDTO> listAllUsers(Pageable pageable) {
        return null;
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

}
