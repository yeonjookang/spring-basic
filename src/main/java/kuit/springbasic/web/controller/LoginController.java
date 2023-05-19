package kuit.springbasic.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import kuit.springbasic.web.dao.UserDao;
import kuit.springbasic.web.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class LoginController {

    private final UserDao userDao;
    @RequestMapping("/loginForm")
    public String forwardUserLoginForm() {
        return "/user/login";
    }

    @RequestMapping("/loginFailed")
    public String forwardUserLoginFiled() {
        return "/user/loginFailed";
    }

    @RequestMapping("/login")
    public String login(@RequestParam("userId") String userId, @RequestParam("password") String password,
                        HttpServletRequest request){

        User loggedInUser = new User(userId,password);

    }
}

