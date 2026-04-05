package com.finance.dashboard.service;

import com.finance.dashboard.dto.TransactionDTO;
import java.util.List;

public interface TransactionService {

    List<TransactionDTO> findAllTransactionsDTO();

    TransactionDTO findTransactionByIdDTO(Long id);

    TransactionDTO saveTransactionDTO(TransactionDTO dto);

    TransactionDTO updateTransaction(Long id, TransactionDTO dto);

    void deleteTransactionById(Long id);
    void deleteTransaction(Long id);
}