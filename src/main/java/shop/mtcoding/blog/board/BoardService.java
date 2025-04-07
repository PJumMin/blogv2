package shop.mtcoding.blog.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.blog.user.User;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepositoty;

    @Transactional
    public void 글쓰기(BoardRequest.SaveDTO saveDTO, User sessionuser) {
        Board board = saveDTO.toEntity(sessionuser);
        boardRepositoty.save(board);
    }

    public List<Board> 글목록보기(Integer userId) {
        return boardRepositoty.findAll(userId);
    }

    public BoardResponse.DetailDTO 글상세보기(Integer id, Integer userId) {
        Board board = boardRepositoty.findByIdJoinUser(id);
        BoardResponse.DetailDTO detailDTO = new BoardResponse.DetailDTO(board, userId);

        return detailDTO;
    }
}
