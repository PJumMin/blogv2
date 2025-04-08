package shop.mtcoding.blog.love;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// 비지니스로직, 트랜잭션처리, DTO 완료
@RequiredArgsConstructor
@Service
public class LoveService {
    private final LoveRepository loveRepository;


}