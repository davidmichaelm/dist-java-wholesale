package edu.wctc.wholesale.controller;

import edu.wctc.wholesale.dto.Order;
import edu.wctc.wholesale.entity.WholesaleOrder;
import edu.wctc.wholesale.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/orders")
@org.springframework.web.bind.annotation.RestController
public class RestController {

    private OrderService orderService;
    private ModelMapper modelMapper;

    @Autowired
    public RestController(OrderService orderService, ModelMapper modelMapper) {
        this.orderService = orderService;

        this.modelMapper = modelMapper;
        configModelMapper();
    }

    private void configModelMapper() {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        this.modelMapper.typeMap(WholesaleOrder.class, Order.class).addMappings(mapper -> {
            mapper.map(WholesaleOrder::getPurchaseOrderNumber, Order::setPoNumber);
            mapper.map(WholesaleOrder::getPurchaseDate, Order::setDate);
            mapper.map(WholesaleOrder::getShippedDate, Order::setShipped);
            mapper.map(o -> o.getProduct().getCost(), Order::setTotal);
        });
    }

    private Order convertToDto(WholesaleOrder wholesaleOrder) {
        return modelMapper.map(wholesaleOrder, Order.class);
    }


    @GetMapping("/")
    public List<Order> getAllOrders() {
        return orderService.getOrderList().stream()
                .map(this::convertToDto).collect(Collectors.toList());
    }
}
