package com.balancee.kale_project.repository;

import com.balancee.kale_project.dto.CashbackTransactionResponse;
import com.balancee.kale_project.model.CashbackTransaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CashbackTransactionRepository extends JpaRepository<CashbackTransaction, Long> {


    Page<CashbackTransactionResponse> findByCustomerId(Long customerId, Pageable pageable);
}
