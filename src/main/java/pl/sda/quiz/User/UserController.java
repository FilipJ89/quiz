package pl.sda.quiz.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/registration")
    public String showRegisterForm(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "/userForms/registration";
    }

    @PostMapping("/registration")
    public String registerUser(@ModelAttribute @Valid RegisterForm registerForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "/userForms/registration";
        }

        User user = new User();
        user.setFirstName(registerForm.getFirstName());
        user.setLastName(registerForm.getLastName());
        user.setEmail(registerForm.getEmail());
        user.setPassword(registerForm.getPassword());

        userRepository.save(user);
        model.addAttribute("user",user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "/userForms/login";
    }

}
