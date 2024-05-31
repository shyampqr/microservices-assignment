package com.Order_ms.controller;

import com.Order_ms.model.Order;
import com.Order_ms.repository.OrderRpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderRpository orderRpository;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        // Call Books-ms to update available copies
        String bookServiceUrl = "http://books-ms/books/" + order.getBookId() + "/copies";
        restTemplate.put(bookServiceUrl + "?copies=-1", null);

        return orderRpository.save(order);
    }
}

