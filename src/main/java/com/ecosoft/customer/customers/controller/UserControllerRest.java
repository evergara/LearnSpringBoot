package com.ecosoft.customer.customers.controller;

import com.ecosoft.customer.customers.model.UserDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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


    @GetMapping(value = "/query", params={"name","user"})
    public List<UserDTO> listUsersQuery(@RequestParam(required = false) String name,
                                        @RequestParam(required = false) String user){
        System.out.println("Recovery users All Querye " + name);
        List<UserDTO> list = List.of(new UserDTO(1,"Emerson", "admin","admin"),
                new UserDTO(2,"Brilis", "customer","pass"),
                new UserDTO(2,"Brayam", "customer","123"));
        list = list.stream().filter(u-> u.getName().contains(name)).collect(Collectors.toList());

        return list;
    }

    @PostMapping()
    public String createUser(@RequestBody UserDTO userDTO){
        System.out.println("Creating user " + userDTO.getName());

         URI location = ServletUriComponentsBuilder.
                fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userDTO.getId())
                .toUri();
        return location.toString();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        System.out.println("Deletin user by id " + id);
    }

    @PatchMapping(value = "/{id}")
    public UserDTO updateCredential(Map<String,String> atribute, @PathVariable("id") Integer id){
        UserDTO userDTO = new UserDTO(1,"Emerson", "admin","admin");
        userDTO.setUser(atribute.get("user"));
        userDTO.setUser(atribute.get("pass"));

        return userDTO;
    }
}
