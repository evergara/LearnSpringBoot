package com.ecosoft.customer.customers.controller;

import com.ecosoft.customer.customers.model.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserControllerRest {

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserByID(@PathVariable("id") Integer id){
        System.out.println("Recovery user by id");
        UserDTO userDTO = new UserDTO(1,"Emerson", "admin","admin");

        if (userDTO == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(userDTO);
    }

    @GetMapping()
    public ResponseEntity<List<UserDTO>> listUsers(){
        System.out.println("Recovery users All");
        List<UserDTO> list = List.of(new UserDTO(1,"Emerson", "admin","admin"),
                                    new UserDTO(2,"Brilis", "customer","pass"),
                                    new UserDTO(2,"Brayam", "customer","123"));

        if (list == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(list);
    }


    @GetMapping(value = "/query", params={"name","user"})
    public ResponseEntity<List<UserDTO>> listUsersQuery(@RequestParam(required = false) String name,
                                        @RequestParam(required = false) String user){
        System.out.println("Recovery users All Querye " + name);
        List<UserDTO> list = List.of(new UserDTO(1,"Emerson", "admin","admin"),
                new UserDTO(2,"Brilis", "customer","pass"),
                new UserDTO(3,"Brayan", "customer","123"));
        list = list.stream().filter(u-> u.getName().contains(name)).collect(Collectors.toList());

        if (list == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(list);
    }

    @PostMapping()
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) throws MalformedURLException {
        System.out.println("Creating user " + userDTO.getName());

         URI location = ServletUriComponentsBuilder.
                fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userDTO.getId())
                .toUri();
        //return ResponseEntity.ok(location.toURL().toString()).;
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
        System.out.println("Deletin user by id " + id);
        return ResponseEntity.ok(null);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<UserDTO>  updateCredential(Map<String,String> atribute, @PathVariable("id") Integer id){
        UserDTO userDTO = new UserDTO(1,"Emerson", "admin","admin");
        userDTO.setUser(atribute.get("user"));
        userDTO.setUser(atribute.get("pass"));

        return ResponseEntity.ok(userDTO);
    }
}
