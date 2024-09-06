package com.balancee.kale_project.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CashbackTransactionResponse {

    private Long transactionId;
    private LocalDate transactionDate;
    private BigDecimal amountEarned;
    private String description;

}
