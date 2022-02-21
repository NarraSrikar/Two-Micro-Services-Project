package com.example.account.model;

import com.example.account.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "accounts")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {


    @Id
    @Max(value = 100)
    private Integer accountId;
    @Max(value = 100)
    private Integer customerId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Please provide a date.")
    private Date createdDate;
    @Min(value = 500, message = "Enter minimum amount")
    private Double accountBalance;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private Boolean active;
}
