package com.example.ebankingbackend.repositories;

import com.example.ebankingbackend.entities.AccoutOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountOperationRepository extends JpaRepository<AccoutOperation, Long> {
     List<AccoutOperation> findByBankAccount_Id(String accountId);
    Page<AccoutOperation> findByBankAccount_Id(String accountId, Pageable pageable);

}
