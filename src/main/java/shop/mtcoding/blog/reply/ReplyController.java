package shop.mtcoding.blog.reply;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import shop.mtcoding.blog.user.User;

@RequiredArgsConstructor
@Controller
public class ReplyController {
    private final ReplySerivce replyService;

    @PostMapping("/reply/save")
    public String save(ReplyRequest.SaveDTO saveDTO, User sessionId) {
        replyService.댓글쓰기(saveDTO, sessionId);
        return "redirect:/board/4";
    }
}
