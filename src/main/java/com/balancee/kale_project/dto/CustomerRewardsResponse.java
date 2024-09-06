package com.balancee.kale_project.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CustomerRewardsResponse {
    private Long customerId;
    private BigDecimal totalCashback;
    private BigDecimal currentBalance;
}
