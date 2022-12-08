package ba.sum.fsre.knjiznica.controller;

import ba.sum.fsre.knjiznica.model.User;
import ba.sum.fsre.knjiznica.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/register")
    public String showRegistrationForm (Model model) {
        model.addAttribute("user", new User());
        return "register_form";
    }

    @PostMapping("/register_user")
    public String registerUser (User user) {
        userRepo.save(user);
        return "register_form";
    }
}
