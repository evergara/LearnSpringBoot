package com.ecosoft.customer.customers.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@ApiModel(description = "User DTO")
public class UserDTO  extends RepresentationModel<UserDTO> {
    @NonNull
    @ApiModelProperty(notes = "Unique identifier of the User.", example = "1", required = true, position = 0)
    private Integer id;
    @NonNull
    private String name;
    @NonNull
    private String user;
    @NonNull
    private String pass;
}
