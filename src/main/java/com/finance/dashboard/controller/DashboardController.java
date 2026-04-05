package com.finance.dashboard.controller;

import com.finance.dashboard.dto.TransactionDTO;
import com.finance.dashboard.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping
    public Map<String, Object> getDashboard() {

        Map<String, Object> data = new HashMap<>();

        data.put("totalUsers", dashboardService.getTotalUsers());
        data.put("totalTransactions", dashboardService.getTotalTransactions());
        data.put("recentTransactions", dashboardService.getRecentTransactions());

        return data;
    }
}