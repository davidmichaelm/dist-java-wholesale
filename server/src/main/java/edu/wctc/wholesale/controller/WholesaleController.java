package edu.wctc.wholesale.controller;

import edu.wctc.wholesale.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WholesaleController {

    private OrderService orderService;

    @Autowired
    public WholesaleController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/")
    public String showIndex(Model model) {
        model.addAttribute("orderList", orderService.getOrderList());
        return "index";
    }

}
