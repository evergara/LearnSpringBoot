package com.ecosoft.customer.customers.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import java.util.List;

@Data
@AllArgsConstructor
public class MessagesApiError {
    private HttpStatus status;
    private String message;
    private List<String> errors;
}

