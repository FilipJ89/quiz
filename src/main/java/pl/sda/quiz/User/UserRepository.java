package pl.sda.quiz.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sda.quiz.entity.Question;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.firstName = ?1")
    public User findUserByName(String questionText);
}
