package shop.mtcoding.blog.user;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserRepository {
    private final EntityManager em;

    public User findById(Integer id) {
        return em.find(User.class, id);
    }

    public User findByUsername(String username) {
        try {
            return em.createQuery("select u from User u where u.username = :username", User.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    /*
        1. createNativeQuery -> 기본쿼리
        2. createQuery -> JPA가 제공해주는 객체지향 쿼리
        3, NamedQuery -> Query Method는 함수 이름으로 쿼리 생성 - 하지말기
        4. EntityGraph -> 지금 이해 불가능
    */
    public void save(User user) {
        em.persist(user);
    }

//    위에 함수와 동일함
//    public void join(UserRequest.JoinDTO joinDTO) {
//        Query query = em.createNativeQuery("insert into user_tb(username, password, email, created_at) values (?, ?, ?,now())");
//        query.setParameter(1, joinDTO.username);
//        query.setParameter(2, joinDTO.password);
//        query.setParameter(3, joinDTO.email);
//        query.executeUpdate();
//    }
}
