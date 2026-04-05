package com.finance.dashboard.service.impl;

import com.finance.dashboard.dto.TransactionDTO;
import com.finance.dashboard.entity.Transaction;
import com.finance.dashboard.repository.TransactionRepository;
import com.finance.dashboard.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    // ✅ GET ALL
    @Override
    public List<TransactionDTO> findAllTransactionsDTO() {
        return transactionRepository.findAll().stream().map(t -> new TransactionDTO(
                t.getId(),
                t.getAmount(),
                t.getDate(),
                t.getType(),
                t.getCategory(),
                t.getDescription())).toList();
    }

    // ✅ GET BY ID
    @Override
    public TransactionDTO findTransactionByIdDTO(Long id) {
        Transaction t = transactionRepository.findById(id).orElse(null);

        if (t == null)
            return null;

        return new TransactionDTO(
                t.getId(),
                t.getAmount(),
                t.getDate(),
                t.getType(),
                t.getCategory(),
                t.getDescription());
    }

    // ✅ SAVE
    @Override
    public TransactionDTO saveTransactionDTO(TransactionDTO dto) {

        Transaction transaction = new Transaction();

        transaction.setAmount(dto.getAmount());
        transaction.setDate(dto.getDate());
        transaction.setType(dto.getType());
        transaction.setCategory(dto.getCategory());
        transaction.setDescription(dto.getDescription());

        Transaction saved = transactionRepository.save(transaction);

        return new TransactionDTO(
                saved.getId(),
                saved.getAmount(),
                saved.getDate(),
                saved.getType(),
                saved.getCategory(),
                saved.getDescription());
    }

    // ✅ DELETE
    @Override
    public void deleteTransactionById(Long id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public TransactionDTO updateTransaction(Long id, TransactionDTO dto) {

        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        transaction.setAmount(dto.getAmount());
        transaction.setDate(dto.getDate());
        transaction.setType(dto.getType());
        transaction.setCategory(dto.getCategory());
        transaction.setDescription(dto.getDescription());

        Transaction updated = transactionRepository.save(transaction);

        return new TransactionDTO(
                updated.getId(),
                updated.getAmount(),
                updated.getDate(),
                updated.getType(),
                updated.getCategory(),
                updated.getDescription());

    }

    @Override
    public void deleteTransaction(Long id) {

        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        transactionRepository.delete(transaction);
    }
}