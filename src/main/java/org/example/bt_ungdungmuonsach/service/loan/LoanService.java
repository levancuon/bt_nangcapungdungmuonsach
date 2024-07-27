package org.example.bt_ungdungmuonsach.service.loan;

import org.example.bt_ungdungmuonsach.model.Book;
import org.example.bt_ungdungmuonsach.model.Loan;
import org.example.bt_ungdungmuonsach.repository.BookRepository;
import org.example.bt_ungdungmuonsach.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class LoanService implements ILoanService {
    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Iterable<Loan> findAll() {
        return loanRepository.findAll();
    }

    @Override
    public void loan(Loan loan) throws Exception {
        Book book=loan.getBook();
        if (book.getQuantity() == 0) {
            throw new RuntimeException("Book out of stock");
        }
        if(book.getQuantity() > 0) {
            loanRepository.save(loan);
            book.setQuantity(book.getQuantity() - 1);
            bookRepository.save(book);
        } else {
                throw new Exception();

        }
    }

    public String getRandomCode() {
        Long randomLongInRange = ThreadLocalRandom.current().nextLong(100, 999);
        if (randomLongInRange > 500) {
            return "GTH-" + randomLongInRange;
        }
        return "FTH-" + randomLongInRange;
    }

    @Override
    public Loan findById(Long id) {
        return loanRepository.findById(id).orElse(null);
    }



    @Override
    public void returnBorrow(Loan loan) {
        Book book = loan.getBook();
        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);
        loan.setStatus(true);
        loanRepository.save(loan);
    }
}
