package shop.mtcoding.blog.temp;

public class Member {
    private int id;
    private String name;
    private String password;

    public static Member builder() {
        return new Member();
    }

    public Member id(int id) {
        this.id = id;
        return this;
    }

    public Member name(String name) {
        this.name = name;
        return this;
    }

    public Member password(String password) {
        this.password = password;
        return this;
    }

    public static void main(String[] args) {

        Member m = Member.builder()
                .id(1)
                .name("길동");

    }
}