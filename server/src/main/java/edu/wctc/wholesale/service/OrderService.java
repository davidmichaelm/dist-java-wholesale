package edu.wctc.wholesale.service;

import edu.wctc.wholesale.entity.WholesaleOrder;

import java.util.List;

public interface OrderService {
    List<WholesaleOrder> getOrderList();
}
