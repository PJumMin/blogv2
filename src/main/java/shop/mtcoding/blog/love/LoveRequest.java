package shop.mtcoding.blog.love;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import shop.mtcoding.blog.board.Board;
import shop.mtcoding.blog.user.User;

public class LoveRequest {

    @Data
    public static class SaveDTO {
        @NotEmpty(message = "boardId가 전달")
        private Integer boardId;

        public Love toEntity(Integer sessionUserId) {
            return Love.builder()
                    .board(Board.builder().id(boardId).build())
                    .user(User.builder().id(sessionUserId).build())
                    .build();
        }
    }
}
