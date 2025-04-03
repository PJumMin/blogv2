package shop.mtcoding.blog.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    // UserJoinPage
    @GetMapping("/join-form")
    public String joinForm() {
        return "/user/join-form";
    }

    // UserJoin
    @PostMapping("/join")
    public String join(UserRequest.JoinDTO joinDTO) {
        userService.join(joinDTO);
        return "redirect:/login-form";
    }

    // UserLoginPage
    @GetMapping("/login-form")
    public String loginForm() {
        return "/user/login-form";
    }

    //UserLogin
    @PostMapping("/login")
    public String login(UserRequest.LoginDTO loginDTO) {
        userService.login(loginDTO);
        return "redirect:/";
    }
}
