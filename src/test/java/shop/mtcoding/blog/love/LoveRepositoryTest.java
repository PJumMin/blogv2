package shop.mtcoding.blog.love;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@Import(LoveRepository.class) // BoardRepository
@DataJpaTest // EntityManager, PC
public class LoveRepositoryTest {

    @Autowired // DI
    private LoveRepository loveRepository;

    @Test
    public void findAll_test() {
        // given
        Integer id = 4;

        // when
//        Board board = loveRepository.findByUserIdAndBoardId(null, id);


        // eye
    }
}
