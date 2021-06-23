package com.ecosoft.customer.customers.model;

import lombok.*;

@Data
public class CustomerDTO {

    @NonNull
    private Integer id;
    @NonNull
    private String name;
    private String lastname;
    @NonNull
    private String email;
    @ToString.Exclude
    private int ego;

}
