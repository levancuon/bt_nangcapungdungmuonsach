package org.example.bt_ungdungmuonsach.controller;

import org.example.bt_ungdungmuonsach.model.Book;
import org.example.bt_ungdungmuonsach.service.book.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping("")
    public String listBook(Model model) {
        Iterable<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "/book/book";
    }
//    @PostMapping("{id}/loan")
//    public String loan(@PathVariable Long id){
//        bookService.loan(id);
//        return "redirect:/books";
//    }
    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("book",new Book());
        return "/book/create";
    }
    @PostMapping("/create")
    public String save(@Validated @ModelAttribute("book") Book book, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasFieldErrors()){
            return "/book/create";
        }
        redirectAttributes.addFlashAttribute("message","Thêm sách thành công");
        bookService.save(book);
        return "redirect:/books";
    }
    @GetMapping("{id}/delete")
    public String deleteBook(@PathVariable Long id){
        bookService.deleteById(id);
        return "redirect:/books";
    }
    @GetMapping("{id}/edit")
    public String showFormEdit(@PathVariable Long id,Model model){
       Book book = bookService.findById(id);
       if(book==null){
           return "redirect:/books";
       }
        model.addAttribute("book",book);
        return "/book/edit";
    }
    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute("book") Book book, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasFieldErrors()){
            return "/book/edit";
        }
        redirectAttributes.addFlashAttribute("message","Thêm sách thành công");
        bookService.save(book);
        return "redirect:/books";
    }
}