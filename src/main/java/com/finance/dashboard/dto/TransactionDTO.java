package com.finance.dashboard.dto;

import java.time.LocalDate;

public class TransactionDTO {

    private Long id;
    private Double amount;
    private LocalDate date;
    private String type;
    private String category;
    private String description;

    public TransactionDTO() {
    }

    public TransactionDTO(Long id, Double amount, LocalDate date,
                          String type, String category, String description) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.type = type;
        this.category = category;
        this.description = description;
    }

    // Getters
    public Long getId() { return id; }
    public Double getAmount() { return amount; }
    public LocalDate getDate() { return date; }
    public String getType() { return type; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setAmount(Double amount) { this.amount = amount; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setType(String type) { this.type = type; }
    public void setCategory(String category) { this.category = category; }
    public void setDescription(String description) { this.description = description; }
}