package ba.sum.fsre.knjiznica.controller;

import ba.sum.fsre.knjiznica.model.Book;
import ba.sum.fsre.knjiznica.model.UserDetails;
import ba.sum.fsre.knjiznica.repositories.BookRepository;
import jakarta.validation.Valid;
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
        model.addAttribute("activeLink", "Knjige");
        return "books";
    }

    @GetMapping("books/add")
    public String showAddBookForm (Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("activeLink", "Knjige");
        model.addAttribute("userDetails", userDetails);
        model.addAttribute("book", new Book());
        return "add_book";
    }

    @PostMapping("books/add")
    public String addBook (@Valid Book book, BindingResult result, Model model) {
        boolean errors = result.hasErrors();
        if (errors) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            model.addAttribute("activeLink", "Knjige");
            model.addAttribute("userDetails", userDetails);
            model.addAttribute("book", book);
            return "add_book";
        }
        bookRepo.save(book);
        return "redirect:books";
    }
}
