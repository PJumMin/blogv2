package shop.mtcoding.blog.board;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import shop.mtcoding.blog.user.User;

@RequiredArgsConstructor
@Controller
public class BoardController {
    private final BoardService boardService;
    private final HttpSession session;

    // HomePage
    @GetMapping("/")
    public String list() {
        return "/board/list";
    }

    // BoardSavePage
    @GetMapping("/board/save-form")
    public String saveForm() {
        User sessionuser = (User) session.getAttribute("sessionUser");
        if (sessionuser == null) throw new RuntimeException("로그인 후 사용해주세요.");
        return "/board/save-form";
    }

    // BoarSave
    @PostMapping("/board/save")
    public String save(BoardRequest.SaveDTO saveDTO) {
        User sessionuser = (User) session.getAttribute("sessionUser");
        if (sessionuser == null) throw new RuntimeException("로그인 후 사용해주세요.");
        boardService.글쓰기(saveDTO, sessionuser);
        return "redirect:/";
    }
}
