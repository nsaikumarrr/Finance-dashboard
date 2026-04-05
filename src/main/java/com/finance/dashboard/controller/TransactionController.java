package com.finance.dashboard.controller;

import com.finance.dashboard.dto.TransactionDTO;
import com.finance.dashboard.service.TransactionService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions") // ✅ IMPORTANT
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // ✅ GET ALL
    @GetMapping
    public List<TransactionDTO> getAllTransactions() {
        return transactionService.findAllTransactionsDTO();
    }

    // ✅ GET BY ID
    @GetMapping("/{id}")
    public TransactionDTO getTransactionById(@PathVariable Long id) {
        return transactionService.findTransactionByIdDTO(id);
    }

    // ✅ SAVE
    @PostMapping
    public TransactionDTO saveTransaction(@RequestBody TransactionDTO dto) {
        return transactionService.saveTransactionDTO(dto);
    }

    @PutMapping("/{id}")
    public TransactionDTO updateTransaction(@PathVariable Long id, @RequestBody TransactionDTO dto) {
        return transactionService.updateTransaction(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return "Transaction deleted successfully";
    }

}
