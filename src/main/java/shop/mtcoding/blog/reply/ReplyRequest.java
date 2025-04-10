package shop.mtcoding.blog.reply;

import lombok.Data;
import shop.mtcoding.blog.board.Board;
import shop.mtcoding.blog.user.User;

import java.sql.Timestamp;

public class ReplyRequest {

    @Data
    public static class SaveDTO {
        private Integer id;
        private Integer boardId;
        private String content;
        private Timestamp createdAt;
        private Integer userId;

        public Reply toEntity(Reply reply) {
            return Reply.builder()
                    .board(Board.builder().id(boardId).build())
                    .content(content)
                    .user(User.builder().id(userId).build())
                    .id(id)
                    .build();
        }
    }
}
