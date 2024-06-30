package web.DAO;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaolmp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public void update(Long id, User user) {
        user = entityManager.find(User.class, id);
        user.setName(user.getName());
        user.setLast_name(user.getLast_name());
        user.setEmail(user.getEmail());
        user.setAge(user.getAge());
        entityManager.merge(user);
    }

    @Override
    public void delete(User user) {
        user = entityManager.find(User.class, user.getId());
        entityManager.remove(user);
    }
}
