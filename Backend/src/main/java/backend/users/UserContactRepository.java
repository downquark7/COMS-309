package backend.users;

import org.springframework.data.jpa.repository.JpaRepository;

/***
 * user contact jpa repository interface
 */
public interface UserContactRepository extends JpaRepository<UserContact, Integer>
{}
