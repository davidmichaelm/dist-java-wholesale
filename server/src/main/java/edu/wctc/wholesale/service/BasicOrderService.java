package edu.wctc.wholesale.service;

import edu.wctc.wholesale.entity.WholesaleOrder;
import edu.wctc.wholesale.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicOrderService implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public BasicOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<WholesaleOrder> getOrderList() {
        return orderRepository.findAll();
    }
}
