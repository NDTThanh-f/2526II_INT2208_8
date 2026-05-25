package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LoanApprovalModule {
    public static String approveLoan(int age, double income, int credit_score, char employment) {
        // Invalid input check
        if (age < 18 || age > 65
                || income < 5.0 || income > 500.0
                || credit_score < 300 || credit_score > 850
                || !(employment == 'C' || employment == 'F')) {

            return "Invalid Input";
        }

        income = BigDecimal.valueOf(income).setScale(1, RoundingMode.HALF_UP).doubleValue();

        // Rule 1
        if (credit_score <= 500) {
            return "REJECT";
        }

        if (credit_score <= 700) {
            // Rule 2
            if (income < 15.0) {
                return "REJECT";
            }

            // Rule 3
            if (employment == 'C') {
                return "APPROVE";
            }

            // Rule 4
            return "MANUAL REVIEW";
        }

        if (income < 15.0) {
            // Rule 5
            if (employment == 'C') {
                return "MANUAL REVIEW";
            }

            // Rule 6
            return "REJECT";
        }

        // Rule 7
        if (employment == 'C') {
            return "APPROVE";
        }

        // Rule 8
        return "MANUAL REVIEW";
    }
}
