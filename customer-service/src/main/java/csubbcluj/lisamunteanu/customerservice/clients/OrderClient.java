package csubbcluj.lisamunteanu.customerservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "order-service")
public interface OrderClient {
    @GetMapping("/")
    Object getOrdersForCustomer(@RequestParam("customerId") int customerId);
}