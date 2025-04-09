package shop.mtcoding.blog.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import shop.mtcoding.blog.reply.Reply;

@Import(BoardRepository.class) // BoardRepository
@DataJpaTest // EntityManager, PC
public class BoardRepositoryTest {

    @Autowired // DI
    private BoardRepository boardRepository;

    @Test
    public void findAll_test() {
        // given
        Integer id = 4;

        // when
        Board board = boardRepository.findById(id);
    }

    @Test
    public void findByIdJoinUserAndReplies_test() {
        // given
        Integer boardId = 4;
        Board board = boardRepository.findByIdJoinUserAndReplies(boardId);


        for (Reply reply : board.getReplies()) {
            System.out.println("-----------------------------------Lazy Loading Select");
            System.out.println(reply.getUser().getUsername());
            System.out.println("------------------------");
        }
    }

//        // Lazy -> Board -> User(id=1)
//        // Eager -> N+1  -> Board조회 -> 연관된 User 유저 수 만큼 주회
//        // Eager -> Join -> 한방쿼리
//        System.out.println("--------------------");
//        boardList.get(0).getUser().getUsername();
//        System.out.println("--------------------");
    // eye
}

