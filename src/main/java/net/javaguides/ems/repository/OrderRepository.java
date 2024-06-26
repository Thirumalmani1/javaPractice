package net.javaguides.ems.repository;

import net.javaguides.ems.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findByOrderTrackingNumber(String orderTrackingNumber);
}
