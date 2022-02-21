package com.example.customer.feign;

import com.example.customer.model.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "account-app", fallbackFactory = HystrixFallBackFactory.class)
public interface AccountFeignClient {

    @GetMapping(value = "/account/id/{id}")
    Account getId(@PathVariable Integer id);
}
