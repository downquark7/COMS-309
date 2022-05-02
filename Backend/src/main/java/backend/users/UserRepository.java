package backend.users;

import org.springframework.data.jpa.repository.JpaRepository;

/***
 * user table jpa repository interface
 */
public interface UserRepository extends JpaRepository<User, Integer>
{
    public boolean existsByUsername(String username);
    public User findByUsername(String username);
}
