package studyhelper.com.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import studyhelper.com.models.User;

public interface UserDAO extends JpaRepository <User, Long> {
    User findByUsername(String username);
}
