package org.example.bt_ungdungmuonsach.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nameCustomer;

    private boolean status = false;

    private String loanCode;

    @NotNull
    private Date loanDate;

    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;


}
