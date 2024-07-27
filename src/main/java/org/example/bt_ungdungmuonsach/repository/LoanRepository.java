package org.example.bt_ungdungmuonsach.repository;

import org.example.bt_ungdungmuonsach.model.Book;
import org.example.bt_ungdungmuonsach.model.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends PagingAndSortingRepository<Loan,Long> , CrudRepository<Loan,Long> {



}
