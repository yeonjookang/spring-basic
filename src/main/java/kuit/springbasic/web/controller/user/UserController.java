package kuit.springbasic.web.controller.user;

import jakarta.servlet.http.HttpSession;
import kuit.springbasic.web.domain.User;
import kuit.springbasic.web.service.UserService;
import kuit.springbasic.web.util.UserSessionUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/form")
    public String showSignUpForm(){
        return "/user/form";
    }

    @GetMapping("/list")
    public String showUserList(HttpSession httpSession, Model model){
        if(UserSessionUtils.isLoggedIn(httpSession)){
            model.addAttribute("users",userService.showAll());
            return "/user/list";
        }
        return "redirect:/user/loginForm";
    }

    @PostMapping("/signup")
    public String createUser(@ModelAttribute User user){
        userService.signUp(user);
        return "redirect:/";
    }

}
