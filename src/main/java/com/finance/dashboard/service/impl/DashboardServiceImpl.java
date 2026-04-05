package com.finance.dashboard.service.impl;

import com.finance.dashboard.dto.TransactionDTO;
import com.finance.dashboard.entity.Transaction;
import com.finance.dashboard.repository.TransactionRepository;
import com.finance.dashboard.repository.UserRepository;
import com.finance.dashboard.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<TransactionDTO> getRecentTransactions() {

        List<Transaction> transactions = transactionRepository.findTop5ByOrderByDateDesc();

        return transactions.stream().map(t -> new TransactionDTO(
                t.getId(),
                t.getAmount(),
                t.getDate(),
                t.getType(),
                t.getCategory(),
                t.getDescription())).toList();
    }

    @Override
    public long getTotalTransactions() {
        return transactionRepository.count();
    }

    @Override
    public long getTotalUsers() {
        return userRepository.count();
    }
}