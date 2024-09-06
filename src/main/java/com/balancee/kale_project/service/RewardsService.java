package com.balancee.kale_project.service;

import com.balancee.kale_project.dto.CashbackTransactionResponse;
import com.balancee.kale_project.dto.CustomerRewardsResponse;
import com.balancee.kale_project.repository.CashbackTransactionRepository;
import com.balancee.kale_project.repository.CustomerRewardsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class RewardsService {

    private static final Logger logger = LoggerFactory.getLogger(RewardsService.class);

    @Autowired
    private CustomerRewardsRepository customerRewardsRepository;

    @Autowired
    private CashbackTransactionRepository cashbackTransactionRepository;

    // Method to retrieve rewards balance
    public CustomerRewardsResponse getRewardsBalance(Long customerId) {
        logger.info("Retrieving rewards balance for customerId: {}", customerId);
        return customerRewardsRepository.findByCustomerId(customerId)
                .orElseThrow(() -> {
                    logger.error("Customer with id {} not found", customerId);
                    return new RuntimeException("Customer not found");
                });
    }

    // Method to retrieve cashback history with pagination
    public Page<CashbackTransactionResponse> getCashbackHistory(Long customerId, int page, int size) {
        logger.info("Retrieving cashback history for customerId: {}, page: {}, size: {}", customerId, page, size);
        Pageable pageable = PageRequest.of(page, size);

        Page<CashbackTransactionResponse> transactions = cashbackTransactionRepository.findByCustomerId(customerId, pageable);

        if (transactions.isEmpty()) {
            logger.warn("No cashback transactions found for customerId: {}", customerId);
        }

        logger.info("Retrieved {} cashback transactions for customerId: {}", transactions.getTotalElements(), customerId);
        return transactions;
    }
}
