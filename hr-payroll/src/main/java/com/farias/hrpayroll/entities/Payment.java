package com.farias.hrpayroll.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    private String nome;
    private Double dailyIncome;
    private Integer days;
    

    public double getTotal() {
        return this.days * this.dailyIncome;
    }
    
}
