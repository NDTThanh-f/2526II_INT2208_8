package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoanApprovalModuleTest {

    @Test
    @DisplayName("TC_01 - Invalid Input: Age too low (< 18)")
    void invalidAgeTest1() {
        assertEquals(
                "Invalid Input",
                LoanApprovalModule.approveLoan(17, 250.0, 600, 'C')
        );
    }

    @Test
    @DisplayName("TC_02 - Invalid Input: Age too high (> 65)")
    void invalidAgeTest2() {
        assertEquals(
                "Invalid Input",
                LoanApprovalModule.approveLoan(66, 250.0, 600, 'F')
        );
    }

    @Test
    @DisplayName("TC_03 - Invalid Input: Credit score too low (< 300)")
    void invalidCreditScoreTest1() {
        assertEquals(
                "Invalid Input",
                LoanApprovalModule.approveLoan(35, 250.0, 299, 'C')
        );
    }

    @Test
    @DisplayName("TC_04 - Invalid Input: Credit score too high (> 850)")
    void invalidCreditScoreTest2() {
        assertEquals(
                "Invalid Input",
                LoanApprovalModule.approveLoan(35, 250.0, 851, 'F')
        );
    }

    @Test
    @DisplayName("TC_05 - Invalid Input: Income too low (< 5.0)")
    void invalidIncomeTest1() {
        assertEquals(
                "Invalid Input",
                LoanApprovalModule.approveLoan(35, 4.9, 600, 'C')
        );
    }

    @Test
    @DisplayName("TC_06 - Invalid Input: Income too high (> 500.0)")
    void invalidIncomeTest2() {
        assertEquals(
                "Invalid Input",
                LoanApprovalModule.approveLoan(35, 500.1, 600, 'F')
        );
    }

    @Test
    @DisplayName("TC_07 - Invalid Input: Wrong type of employment (not 'C' or 'F')")
    void invalidEmploymentTest() {
        assertEquals(
                "Invalid Input",
                LoanApprovalModule.approveLoan(35, 250.0, 600, 'A')
        );
    }

    @Test
    @DisplayName("TC_08 - Rule 1 test #1 (Credit score = 300)")
    void rule1Test1() {
        assertEquals(
                "REJECT",
                LoanApprovalModule.approveLoan(35, 10.0, 300, 'C')
        );
    }

    @Test
    @DisplayName("TC_09 - Rule 1 test #2 (Credit score = 500)")
    void rule1Test2() {
        assertEquals(
                "REJECT",
                LoanApprovalModule.approveLoan(35, 250.0, 500, 'F')
        );
    }

    @Test
    @DisplayName("TC_10 - Rule 2 test #1 (Income = 5.0)")
    void rule2Test1() {
        assertEquals(
                "REJECT",
                LoanApprovalModule.approveLoan(35, 5.0, 600, 'C')
        );
    }

    @Test
    @DisplayName("TC_11 - Rule 2 test #2 (Income = 14.9)")
    void rule2Test2() {
        assertEquals(
                "REJECT",
                LoanApprovalModule.approveLoan(35, 14.9, 600, 'C')
        );
    }

    @Test
    @DisplayName("TC_12 - Rule 2 test #3: Rounding down income (14.94 -> 14.9)")
    void rule2Test3() {
        assertEquals(
                "REJECT",
                LoanApprovalModule.approveLoan(35, 14.94, 600, 'F')
        );
    }

    @Test
    @DisplayName("TC_13 - Rule 3 test #1 (Credit score = 501)")
    void rule3Test1() {
        assertEquals(
                "APPROVE",
                LoanApprovalModule.approveLoan(35, 250.0, 501, 'C')
        );
    }

    @Test
    @DisplayName("TC_14 - Rule 3 test #2 (Credit score = 700)")
    void rule3Test2() {
        assertEquals(
                "APPROVE",
                LoanApprovalModule.approveLoan(35, 250.0, 700, 'C')
        );
    }

    @Test
    @DisplayName("TC_15 - Rule 3 test #3: Rounding up income (14.95 -> 15.0)")
    void rule3Test3() {
        assertEquals(
                "APPROVE",
                LoanApprovalModule.approveLoan(35, 14.95, 600, 'C')
        );
    }

    @Test
    @DisplayName("TC_16 - Rule 4 test")
    void rule4Test() {
        assertEquals(
                "MANUAL REVIEW",
                LoanApprovalModule.approveLoan(35, 250.0, 600, 'F')
        );
    }

    @Test
    @DisplayName("TC_17 - Rule 5 test")
    void rule5Test() {
        assertEquals(
                "MANUAL REVIEW",
                LoanApprovalModule.approveLoan(35, 10.0, 780, 'C')
        );
    }

    @Test
    @DisplayName("TC_18 - Rule 6 test")
    void rule6Test() {
        assertEquals(
                "REJECT",
                LoanApprovalModule.approveLoan(35, 10.0, 780, 'F')
        );
    }

    @Test
    @DisplayName("TC_19 - Rule 7 test #1 (Age = 18, Credit score = 701)")
    void rule7Test1() {
        assertEquals(
                "APPROVE",
                LoanApprovalModule.approveLoan(18, 250.0, 701, 'C')
        );
    }

    @Test
    @DisplayName("TC_20 - Rule 7 test #2 (Age = 65, Credit score = 850)")
    void rule7Test2() {
        assertEquals(
                "APPROVE",
                LoanApprovalModule.approveLoan(65, 250.0, 850, 'C')
        );
    }

    @Test
    @DisplayName("TC_21 - Rule 7 test #3 (Income = 15.0)")
    void rule7Test3() {
        assertEquals(
                "APPROVE",
                LoanApprovalModule.approveLoan(35, 15.0, 780, 'C')
        );
    }

    @Test
    @DisplayName("TC_22 - Rule 7 test #4 (Income = 500.0)")
    void rule7Test4() {
        assertEquals(
                "APPROVE",
                LoanApprovalModule.approveLoan(35, 500.0, 780, 'C')
        );
    }

    @Test
    @DisplayName("TC_23 - Rule 8 test")
    void rule8Test() {
        assertEquals(
                "MANUAL REVIEW",
                LoanApprovalModule.approveLoan(35, 250.0, 780, 'F')
        );
    }
}