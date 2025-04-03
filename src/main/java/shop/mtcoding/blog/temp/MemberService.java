package shop.mtcoding.blog.temp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepositoty memberRepositoty;
}
