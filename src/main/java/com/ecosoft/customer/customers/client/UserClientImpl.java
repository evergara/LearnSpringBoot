package com.ecosoft.customer.customers.client;

import com.ecosoft.customer.customers.model.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserClientImpl implements IUserClient{
    @Override
    public UserDTO getUser(Integer id) {

        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "https://jsonplaceholder.typicode.com/posts/1";
        UserDTO user = restTemplate.getForObject(fooResourceUrl, UserDTO.class);
        return user;

    }
}
