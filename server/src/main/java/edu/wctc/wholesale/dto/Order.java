package edu.wctc.wholesale.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Order {
    private String customerName;
    private LocalDateTime date;
    private String poNumber;
    private String productName;
    private String terms;
    private LocalDateTime shipped;
    private double total;
}
