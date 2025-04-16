package shop.mtcoding.blog.reply;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import shop.mtcoding.blog.board.Board;
import shop.mtcoding.blog.user.User;

public class ReplyRequest {

    @Data
    public static class SaveDTO {
        @NotEmpty(message = "boardid가 전달")
        private Integer boardId;
        @NotEmpty(message = "내용을 적어주세요.")
        private String content;

        public Reply toEntity(User sessionUser) {
            return Reply.builder()
                    .content(content)
                    .board(Board.builder().id(boardId).build())
                    .user(sessionUser)
                    .build();
        }
    }
}
