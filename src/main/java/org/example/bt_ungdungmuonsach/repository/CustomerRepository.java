package org.example.bt_ungdungmuonsach.repository;

import org.example.bt_ungdungmuonsach.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long>, PagingAndSortingRepository<Customer,Long> {
}
