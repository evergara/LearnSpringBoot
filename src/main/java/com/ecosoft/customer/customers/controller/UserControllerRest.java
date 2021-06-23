package com.ecosoft.customer.customers.controller;

import com.ecosoft.customer.customers.model.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserControllerRest {

    @GetMapping("/{id}")
    public UserDTO getUserByID(@PathVariable("id") Integer id){
        System.out.println("Recovery user by id");
        UserDTO userDTO = new UserDTO(1,"Emerson", "admin","admin");
        return userDTO;
    }

    @GetMapping()
    public List<UserDTO> listUsers(){
        System.out.println("Recovery users All");
        List<UserDTO> list = List.of(new UserDTO(1,"Emerson", "admin","admin"),
                                    new UserDTO(2,"Brilis", "customer","pass"),
                                    new UserDTO(2,"Brayam", "customer","123"));
        return list;
    }

    @PostMapping()
    public String createUser(@RequestBody UserDTO userDTO){
        System.out.println("Creating user " + userDTO.getName());
        return "http://empire.ecosoft.com:8080/users/" + userDTO.getId();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        System.out.println("Deletin user by id " + id);
    }
}
