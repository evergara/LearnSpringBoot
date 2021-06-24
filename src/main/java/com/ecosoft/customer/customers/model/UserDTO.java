package com.ecosoft.customer.customers.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@ApiModel(description = "User DTO")
public class UserDTO  extends RepresentationModel<UserDTO> {

    @NotNull
    @NonNull
    @ApiModelProperty(notes = "Unique identifier of the User.", example = "1", required = true, position = 0)
    private Integer id;


    @NotBlank
    @Size( min = 7, max = 200)
    @NonNull
    private String name;

    @NotBlank
    @Size( min = 7, max = 10)
    @NonNull
    private String user;

    @NotBlank
    @Size( min = 7, max = 16)
    @NonNull
    private String pass;
}
