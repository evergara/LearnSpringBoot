package com.ecosoft.customer.customers.controller;

import com.ecosoft.customer.customers.model.UserDTO;
import com.ecosoft.customer.customers.service.IUserService;
import com.ecosoft.customer.customers.validators.GroupValidatorOnCreate;
import com.ecosoft.customer.customers.validators.GroupValidatorOnUpdate;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/users")
@Api(tags = "User Api Rest")
public class UserControllerRest {

    @Autowired
    //@Qualifier("BD") // Se quita el @Qualifier, porque se define que levantas por @ConditionalOnProperty
    private IUserService service;

    @GetMapping("/{id}")
    @ApiOperation(notes="Retrieve one user system by id",value="Get user by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Response ok if the operation was successful"),
            @ApiResponse(code = 404,message = "Response not found if the resource could not be found")
    })
    public ResponseEntity<UserDTO> getUserByID(@ApiParam(example = "1",value = "Identifier for User",allowableValues = "1,2,3,4",required = true)
                                                   @PathVariable("id") Integer id){
        System.out.println("Recovery user by id");
        UserDTO userDTO = service.getUserById(id);

        addLinkHATEOAS(userDTO);

        if (userDTO == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(userDTO);
    }

    private void addLinkHATEOAS(UserDTO userDTO) {
        Link withSelfRel =  linkTo(methodOn(UserControllerRest.class).
                getUserByID(userDTO.getId())).withSelfRel();
        userDTO.add(withSelfRel);
    }

    @GetMapping()
    public ResponseEntity<CollectionModel<UserDTO>> listUsers(){
        System.out.println("Recovery users All");
        List<UserDTO> list = List.of(new UserDTO(1,"Emerson", "admin","admin"),
                                    new UserDTO(2,"Brilis", "customer","pass"),
                                    new UserDTO(2,"Brayam", "customer","123"));
        for (UserDTO userDTO : list){
            addLinkHATEOAS(userDTO);
        }
        CollectionModel<UserDTO> result = addLinkHATEOASToCollection(linkTo(methodOn(UserControllerRest.class).
                listUsers()).withSelfRel(), list);

        if (list == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result);
    }

    private CollectionModel<UserDTO> addLinkHATEOASToCollection(Link withSelfRel, List<UserDTO> list) {
        CollectionModel<UserDTO> result = CollectionModel.of(list, withSelfRel);
        return  result;
    }


    @GetMapping(value = "/query", params={"name","user"})
    public ResponseEntity<CollectionModel<UserDTO>> listUsersQuery(@RequestParam(required = false) String name,
                                        @RequestParam(required = false) String user){
        System.out.println("Recovery users All Querye " + name);
        List<UserDTO> list = List.of(new UserDTO(1,"Emerson", "admin","admin"),
                                    new UserDTO(2,"Brilis", "customer","pass"),
                                    new UserDTO(3,"Brayan", "negocio","123"),
                                    new UserDTO(4,"Brayan", "socio","1234"));
        list = list.stream().filter(u-> u.getName().contains(name)).collect(Collectors.toList());


        for (UserDTO userDTO : list){
            addLinkHATEOAS(userDTO);
        }
        CollectionModel<UserDTO> result = addLinkHATEOASToCollection(linkTo(methodOn(UserControllerRest.class).
                listUsersQuery(name, user)).withSelfRel(), list);


        if (list == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result);
    }

    @PostMapping()
    public ResponseEntity<String> createUser(@Validated(value = GroupValidatorOnCreate.class) @RequestBody UserDTO userDTO) throws MalformedURLException {
        System.out.println("Creating user " + userDTO.getName());

         URI location = ServletUriComponentsBuilder.
                fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userDTO.getId())
                .toUri();
        //return ResponseEntity.ok(location.toURL().toString()).;
        return ResponseEntity.created(location).build();
    }

    @PutMapping()
    public ResponseEntity<UserDTO> updatedUser(@Validated(value = GroupValidatorOnUpdate.class) @RequestBody UserDTO userDTO) throws MalformedURLException {
        System.out.println("Updated user " + userDTO.getName());
        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
        System.out.println("Deletin user by id " + id);
        return ResponseEntity.ok(null);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.POST,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO>  updateCredential(Map<String,String> atribute, @PathVariable("id") Integer id){
        UserDTO userDTO = new UserDTO(1,"Emerson", "admin","admin");
        userDTO.setUser(atribute.get("user"));
        userDTO.setUser(atribute.get("pass"));

        return ResponseEntity.ok(userDTO);
    }
}
