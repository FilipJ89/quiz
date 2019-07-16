package pl.sda.quiz.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/registration")
    public String showRegisterForm(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "/userForms/registration";
    }

    @GetMapping("/login")
    public String showLoginForm() {

        return "/userForms/login";
    }

}
