package jp.test.exp.demo.action;

import jp.test.exp.demo.entity.User;
import jp.test.exp.demo.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.List;

@Component
public class CRUDTestAction {
    @Autowired
    private UserJpaRepository userJpaRepository;

    public List<User> getUsers() {
        return userJpaRepository.findAll();
    }

    public User getUserById(Long userId) {
        return userJpaRepository.findById(userId).get();
    }

    public User createUser(User user) {
        User newUser = new User(user);
        return userJpaRepository.save(newUser);
    }

    public User updateUserName(@NotNull  User user) {
        User target = userJpaRepository.findById(user.getId()).get();

        if (!target.getPassword().equals(user.getPassword())) {
            throw new IllegalArgumentException("Not Match Password");
        }

        target.setUserName(user.getUserName());
        return userJpaRepository.save(target);
    }

    public List<User> deleteUser(@NotNull Long id) {
        userJpaRepository.deleteById(id);
        return userJpaRepository.findAll();
    }

    public List<User> findUsersByName(@NotNull String userName) {
        return userJpaRepository.findUsersByName(userName);
    }
}
