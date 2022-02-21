package main.userManagement;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface userRepository extends JpaRepository<userData, Long>
{
    userData findById(int id);

    userData findByUsername(String username);

    @Transactional
    void deleteById(int id);
}
