package shop.mtcoding.blog.board;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import shop.mtcoding.blog.user.User;

@RequiredArgsConstructor
@Controller
public class BoardController {
    private final BoardService boardService;
    private final HttpSession session;

    // BoardDetail
    @GetMapping("/board/{id}")
    public String detail(@PathVariable("id") int id, HttpServletRequest request) {
        User sessionuser = (User) session.getAttribute("sessionUser");
        Integer sessionUserId = (sessionuser == null ? null : sessionuser.getId());
        BoardResponse.DetailDTO detailDTO = boardService.글상세보기(id, sessionUserId);
        request.setAttribute("model", detailDTO);
        return "board/detail";
    }


    // BoardList
    @GetMapping("/")
    public String list(HttpServletRequest request) {
        User sessionuser = (User) session.getAttribute("sessionUser");
        if (sessionuser == null) {
            request.setAttribute("models", boardService.글목록보기(null));
        } else {
            request.setAttribute("models", boardService.글목록보기(sessionuser.getId()));
        }
        return "board/list";
    }

    // BoardSavePage
    @GetMapping("/board/save-form")
    public String saveForm() {
        User sessionuser = (User) session.getAttribute("sessionUser");
        if (sessionuser == null) throw new RuntimeException("로그인 후 사용해주세요.");
        return "board/save-form";
    }

    // BoardSave
    @PostMapping("/board/save")
    public String save(BoardRequest.SaveDTO saveDTO) {
        User sessionuser = (User) session.getAttribute("sessionUser");
        if (sessionuser == null) throw new RuntimeException("로그인 후 사용해주세요.");
        boardService.글쓰기(saveDTO, sessionuser);
        return "redirect:/";
    }

}
