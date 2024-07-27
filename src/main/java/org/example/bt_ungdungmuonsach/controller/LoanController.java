package org.example.bt_ungdungmuonsach.controller;

import org.example.bt_ungdungmuonsach.model.Book;
import org.example.bt_ungdungmuonsach.model.Loan;
import org.example.bt_ungdungmuonsach.service.book.IBookService;
import org.example.bt_ungdungmuonsach.service.loan.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/loan")
public class LoanController {
    @Autowired
    private IBookService bookService;

    @ModelAttribute("books")
    public Iterable<Book> books() {
        return bookService.findAll();
    }

    @Autowired
    private ILoanService loanService;

    @GetMapping("")
    public String list() {
        return "/loan/loan";
    }
    @GetMapping("/loan")
    public String listLoan(Model model) {
        Iterable<Loan> loans = loanService.findAll();
        model.addAttribute("loans", loans);
        return "/loan/listloan";
    }
    @GetMapping("/{id}/loan")
    private String showFormCreate(@PathVariable Long id, Model model) {
        Book book = bookService.findById(id);
        if (book == null) {
            return "redirect:/loan";
        }
        Loan loan = new Loan();
        loan.setLoanCode(loanService.getRandomCode());
        loan.setBook(book);
        model.addAttribute("loan", loan);
        return "/loan/create";
    }
    @PostMapping("/create")
    private String create( @ModelAttribute Loan loan,  RedirectAttributes redirectAttributes){
        try{
            loanService.loan(loan);
            redirectAttributes.addFlashAttribute("message","Mượn thành công");

        }catch (Exception e){
            redirectAttributes.addFlashAttribute("message", "Số lượng không đủ!!");
        }
      return "redirect:/loan";
    }
    @GetMapping("/{id}/return")
    public String delete(@PathVariable Long id) {
        Loan loan = loanService.findById(id);
        loanService.returnBorrow(loan);
        return "redirect:/loan/loan";
    }
}
