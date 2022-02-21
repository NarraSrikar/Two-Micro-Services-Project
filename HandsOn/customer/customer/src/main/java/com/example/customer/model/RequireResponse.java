package com.example.customer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequireResponse {
    private Account account_model;
    private Customer customer_model;
}
