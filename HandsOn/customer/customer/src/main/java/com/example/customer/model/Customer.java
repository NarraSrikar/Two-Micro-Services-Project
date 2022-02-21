package com.example.customer.model;

import com.example.customer.enums.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Document(collection = "customer_db")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {

    @Id
    private Integer id;
    private Integer customerId;
    @Size(max=10,min=1,message="First Name should not be empty")
    @NotBlank(message = "First Name is mandatory")
    private String customerFirstName;
    private String customerMiddleName;
    @Size(max=10,min=1,message="Last Name should not be empty")
    @NotBlank(message = "Last Name is mandatory")
    private String customerLastName;
    @Size(max=10,min=1,message="User Name should not be empty")
    @NotBlank(message = "User Name is mandatory")
    private String customerUserName;
    @NotBlank(message = "Email is mandatory")
    private String emailId;
    @NotBlank(message = "Mobile Number is mandatory")
    private String mobileNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Please provide a date.")
    private Date createdDate;
    @Valid
    @NotNull(groups = Address.class,message = "Address should not be null")
    private Address address;
    private CustomerType customerType;
    private Boolean active;

}
