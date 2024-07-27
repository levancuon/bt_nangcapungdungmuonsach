package org.example.bt_ungdungmuonsach.repository;

import org.example.bt_ungdungmuonsach.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book,Long>, CrudRepository<Book,Long> {
}
