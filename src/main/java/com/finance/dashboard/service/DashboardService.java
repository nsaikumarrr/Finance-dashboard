package com.finance.dashboard.service;

import com.finance.dashboard.dto.TransactionDTO;
import java.util.List;

public interface DashboardService {

    List<TransactionDTO> getRecentTransactions();

    long getTotalTransactions();

    long getTotalUsers();
}