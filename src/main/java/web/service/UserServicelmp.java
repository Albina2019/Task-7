package web.service;

import org.springframework.stereotype.Service;
import web.DAO.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServicelmp implements UserService {
    private UserDao userDao;
    public UserServicelmp(UserDao userDao) {
        this.userDao = userDao;
    }
    @Transactional
    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Transactional
    @Override
    public void update(Long id, User user) {
        userDao.update(id, user);
    }

    @Transactional
    @Override
    public void delete(User user) {
        userDao.delete(user);
    }
}
