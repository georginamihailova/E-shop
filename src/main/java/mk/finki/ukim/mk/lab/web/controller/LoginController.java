package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.model.exceptions.UserDoesNotExistException;
import mk.finki.ukim.mk.lab.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping("/login")
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getLoginPage(){
        return "login";
    }

    @PostMapping
    public String getBalloonPage(@RequestParam String username,
                                 @RequestParam String password, HttpServletRequest request){
        User user = new User(username,password);
        request.getSession().setAttribute("user",user);
        request.getSession().setAttribute("username",username);

        if(this.userService.findByUsernameAndPassword(username,password).isPresent()) {
            return "redirect:/balloons";
        }
        return "redirect:/login";

    }

}
