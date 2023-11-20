package admin_user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import admin_user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    User findByEmail(String email);
}
