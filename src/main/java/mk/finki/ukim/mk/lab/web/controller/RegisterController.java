package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.enumType.Role;
import mk.finki.ukim.mk.lab.model.exceptions.InvalidUsernameOrPassword;
import mk.finki.ukim.mk.lab.model.exceptions.PasswordsDontMatchException;
import mk.finki.ukim.mk.lab.model.exceptions.UsernameExistsException;
import mk.finki.ukim.mk.lab.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getRegisterPage(Model model,@RequestParam(required = false) String error){
        if(error!=null && error.isEmpty()){
            model.addAttribute("hasError",true);
            model.addAttribute("error",error);
        }
        return "register";
    }
    @PostMapping
    public String createUser(@RequestParam String name, @RequestParam String surname, @RequestParam String password, @RequestParam String repeatedPassword,@RequestParam String username,@RequestParam Role role){
        try {
            this.userService.register(username, password, repeatedPassword, name, surname,role);
            System.out.println(this.userService.findByUsername(username));
            return "redirect:/login";
        }catch (PasswordsDontMatchException | InvalidUsernameOrPassword | UsernameExistsException exception){
            return "redirect:/register?error="+exception.getMessage();
        }

    }
}
