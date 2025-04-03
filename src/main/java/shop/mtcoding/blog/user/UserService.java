package shop.mtcoding.blog.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    // UserJoin
    @Transactional
    public void join(UserRequest.JoinDTO joinDTO) {
        // 1. username 중복체크
        User user = userRepository.findByUsername(joinDTO.getUsername());
        // 2. 있으면 오류 터트리기
        if (user != null) throw new RuntimeException("username 중복");

        userRepository.join(joinDTO);
    }

    public User login(UserRequest.LoginDTO loginDTO) {
        // 1. 있는 아이디인가?
        User user = userRepository.findByUsername(loginDTO.getUsername());
        // 2. 아이디와 비밀번호가 일치하는가?
        if (user == null) {
            throw new RuntimeException("아이디가 틀렸습니다");
        }

        if (!(user.getPassword().equals(loginDTO.getPassword()))) {
            throw new RuntimeException("비밀번호가 틀렸습니다");
        }
        return user;
        // 3. 둘 다 맞으면 로그인
    }
}
