package com.balancee.kale_project.repository;

import com.balancee.kale_project.dto.CustomerRewardsResponse;
import com.balancee.kale_project.model.CustomerRewards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRewardsRepository extends JpaRepository<CustomerRewards,Long> {
    Optional<CustomerRewardsResponse> findByCustomerId(Long customerId);
}
