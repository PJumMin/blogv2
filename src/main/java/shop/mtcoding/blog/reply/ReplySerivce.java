package shop.mtcoding.blog.reply;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ReplySerivce {
    private final ReplyRepository replyRepository;

    @Transactional
    public void 댓글쓰기(ReplyRequest.SaveDTO saveDTO) {
        Reply reply = saveDTO.toEntity(saveDTO.getId());
        replyRepository.save(reply);
    }
}
