# Admin-User_Registration_Login_SpringBoot-3.1.5

## @Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    User findByEmail(String email);
}
