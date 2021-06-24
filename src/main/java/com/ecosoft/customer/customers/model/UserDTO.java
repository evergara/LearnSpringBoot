package com.ecosoft.customer.customers.model;


import com.ecosoft.customer.customers.validators.PASS;
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


    @NotBlank(message = "{app.field.name.error}")
    @Size( min = 7, max = 200, message = "{app.field.name.error}")
    @NonNull
    @ApiModelProperty(example = "Administrador")
    private String name;

    @NotBlank(message = "{app.field.user.error}")
    @Size( min = 7, max = 15, message = "{app.field.user.error}")
    @NonNull
    @ApiModelProperty(example = "Administrador")
    private String user;

    @NotBlank(message = "{app.field.pass.error}")
    //@Size( min = 7, max = 16, message = "{app.field.pass.error}")
    @PASS(message = "{app.field.pass.error}")
    @NonNull
    @ApiModelProperty(example = "@@xxjd123dfh456")
    private String pass;
}
