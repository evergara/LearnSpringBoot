package com.ecosoft.customer.customers.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class UserDTO {
    @NonNull
    private Integer id;
    @NonNull
    private String name;
    @NonNull
    private String user;
    @NonNull
    private String pass;
}
