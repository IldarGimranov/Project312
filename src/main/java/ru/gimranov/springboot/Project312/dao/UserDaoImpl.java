package ru.gimranov.springboot.Project312.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.gimranov.springboot.Project312.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> readingAllUsers() {
        return em.createQuery("from User").getResultList();
    }

    @Override
    public User readUser(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        em.persist(user);
    }

    @Override
    public void updateUser(Long id, User user) {
        try {
            User user1 = readUser(id);
            user1.setName(user.getName());
            user1.setLastName(user.getLastName());
            user1.setYear(user.getYear());
            em.merge(user);
        } catch (NullPointerException e) {
            throw new EntityNotFoundException();
        }

    }

    @Override
    public void deleteUser(Long id) {
        em.remove(readUser(id));
    }

}
