package shop.mtcoding.blog.user;

import lombok.Data;

public class UserRequest {

    @Data
    public static class JoinDTO {
        String username;
        String password;
        String email;
    }

    @Data
    public static class LoginDTO {
        String username;
        String password;
    }
}
