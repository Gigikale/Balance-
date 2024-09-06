package com.balancee.kale_project.controller;

import com.balancee.kale_project.dto.CashbackTransactionResponse;
import com.balancee.kale_project.dto.CustomerRewardsResponse;
import com.balancee.kale_project.model.CashbackTransaction;
import com.balancee.kale_project.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rewards")
public class RewardsController {
    @Autowired
    private RewardsService rewardsService;

    @GetMapping("/balance")
    public ResponseEntity<CustomerRewardsResponse> getRewardsBalance(@RequestParam Long customerId) {
        return ResponseEntity.ok(rewardsService.getRewardsBalance(customerId));
    }

    @GetMapping("/history")
    public ResponseEntity<Page<CashbackTransactionResponse>> getCashbackHistory(
            @RequestParam Long customerId,
            @RequestParam(defaultValue = "0") int page,  // Default page is 0
            @RequestParam(defaultValue = "10") int size  // Default size is 10
    ) {
        Page<CashbackTransactionResponse> transactions = rewardsService.getCashbackHistory(customerId, page, size);
        return ResponseEntity.ok(transactions);
    }
}
