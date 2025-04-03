package shop.mtcoding.blog.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserRepository {
    private final EntityManager em;

    public User findByUsername(String username) {
        Query query = em.createNativeQuery("SELECT * FROM user_tb WHERE username=?", User.class);
        query.setParameter(1, username);
        try {
            return (User) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public void join(UserRequest.JoinDTO joinDTO) {
        Query query = em.createNativeQuery("insert into user_tb(username, password, email, created_at) values (?, ?, ?,now())");
        query.setParameter(1, joinDTO.username);
        query.setParameter(2, joinDTO.password);
        query.setParameter(3, joinDTO.email);
        query.executeUpdate();
    }
}
