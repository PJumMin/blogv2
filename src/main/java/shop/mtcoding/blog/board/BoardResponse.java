package shop.mtcoding.blog.board;

import lombok.Data;

import java.sql.Timestamp;

public class BoardResponse {

    @Data
    public static class DetailDTO {
        private Integer id;
        private String title;
        private String content;
        private Boolean isPublic;
        private Boolean isOwner; //
        private Boolean isLove; //
        private Integer loveCount; //
        private String username;
        private Timestamp createdAt;

    }
}
