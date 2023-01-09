package ba.sum.fsre.knjiznica.controller;

import ba.sum.fsre.knjiznica.model.Book;
import ba.sum.fsre.knjiznica.model.User;
import ba.sum.fsre.knjiznica.model.UserDetails;
import ba.sum.fsre.knjiznica.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookRepository bookRepo;

    @GetMapping("books")
    public String listBooks (Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("userDetails", userDetails);
        List<Book> listBooks = bookRepo.findAll();
        model.addAttribute("listBooks", listBooks);
        return "books";
    }

    @GetMapping("books/add")
    public String showAddBookForm (Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("userDetails", userDetails);
        model.addAttribute("book", new Book());
        return "add-book";
    }

    @PostMapping("books_add")
    public String addBook (Book book, BindingResult result, Model model) {
        bookRepo.save(book);
        return "redirect:books";
    }
}
