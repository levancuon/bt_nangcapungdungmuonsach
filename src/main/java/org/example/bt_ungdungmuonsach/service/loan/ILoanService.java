package org.example.bt_ungdungmuonsach.service.loan;

import org.example.bt_ungdungmuonsach.model.Loan;

public interface ILoanService {
    Iterable<Loan> findAll();

    void loan(Loan loan) throws Exception;
    String getRandomCode();

    Loan findById(Long id);

    void returnBorrow(Loan loan);
}
