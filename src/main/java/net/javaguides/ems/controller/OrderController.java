package net.javaguides.ems.controller;

import net.javaguides.ems.entity.OrderItem;
import net.javaguides.ems.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import net.javaguides.ems.entity.Order;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAllOrders() {
        Order order = new Order();

        OrderItem orderItem = new OrderItem();
        orderItem.setImageUrl("image_url.png");
        orderItem.setPrice(new BigDecimal(100));
        // add orderitem to order
        order.add(orderItem);

        OrderItem orderItem2 = new OrderItem();
        orderItem2.setImageUrl("image_url.png");
        orderItem2.setPrice(new BigDecimal(200));
        // add orderItem2 to order
        order.add(orderItem2);

        order.setOrderTrackingNumber("1000");
        order.setStatus("IN PROGRESS");
        // total amount of the order
        order.setTotalPrice(order.getTotalAmount());

        // Quantity of the order items
        order.setTotalQuantity(2);

        orderRepository.save(order);
        List<Order> orders =  orderRepository.findAll();
        return ResponseEntity.ok(orders);
    }
}
