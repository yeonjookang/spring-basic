package kuit.springbasic.web.controller.user;

import jakarta.servlet.http.HttpSession;
import kuit.springbasic.web.domain.User;
import kuit.springbasic.web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class LoginController {
    private final UserService userService;

    @GetMapping("/loginForm")
    public String showLoginForm(){
        return "/user/login";
    }

    @GetMapping("/loginFailed")
    public String showLoginFailed() {
        return "/user/loginFailed";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, HttpSession httpSession) throws SQLException {
        if(userService.isLogin(user)){
            httpSession.setAttribute("user",user);
            return "redirect:/";
        }
        return "redirect:/user/loginFailed";
    }
}
