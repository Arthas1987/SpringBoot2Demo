package jp.test.exp.demo.repository;

import jp.test.exp.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserJpaRepository extends JpaRepository<User, Long> {
    @Query("select a from User a where a.userName = ?1")
    List<User> findUsersByName(String userName);
}
