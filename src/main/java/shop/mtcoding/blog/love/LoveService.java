package shop.mtcoding.blog.love;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// 비지니스로직, 트랜잭션처리, DTO 완료
@RequiredArgsConstructor
@Service
public class LoveService {
    private final LoveRepository loveRepository;


    @Transactional
    public LoveResponse.SaveDTO 좋아요(LoveRequest.SaveDTO reqDTO, Integer sessoionUserId) {
        Love lovePS = loveRepository.save(reqDTO.toEntity(sessoionUserId));
        Long loveCount = loveRepository.findByBoardId(reqDTO.getBoardId());
        return new LoveResponse.SaveDTO(lovePS.getId(), loveCount.intValue());
    }

    @Transactional
    public LoveResponse.DeleteDTO 좋아요취소(Integer id) {

        // 권한체크 (lovePS.getUser().getId() = sessionUser 비교)

        Love lovePS = loveRepository.findById(id);
        if (lovePS == null) throw new RuntimeException("좋아요를 안했는데 취소를 어떻게 해");

        Integer boardId = lovePS.getBoard().getId();

        loveRepository.deleteById(id);

        Long loveCount = loveRepository.findByBoardId(boardId);

        return new LoveResponse.DeleteDTO(loveCount.intValue());
    }
}