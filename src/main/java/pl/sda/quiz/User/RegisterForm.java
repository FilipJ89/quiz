package pl.sda.quiz.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString(exclude = {"password"})
public class RegisterForm {

    @NotBlank(message = "Field can't be left empty")
    private String firstName;

    @NotBlank(message = "Field can't be left empty")
    private String lastName;

    @Pattern(regexp = "[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-z]{2,3}",
            message = "Invalid email")
    private String email;

    @Size(min = 5)
    private String password;
}
