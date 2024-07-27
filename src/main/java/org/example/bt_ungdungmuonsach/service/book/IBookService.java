package org.example.bt_ungdungmuonsach.service.book;

import org.example.bt_ungdungmuonsach.model.Book;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IBookService {


    Iterable<Book> findAll();


     Book findById(Long id);

    void save(Book book);

    void deleteById(Long id);

    void edit(Long id);
}
