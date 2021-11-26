package com.guitarshack;

import java.time.LocalDate;

public interface SalesHistory {
    int total(int productId, LocalDate startDate, LocalDate endDate);
}
