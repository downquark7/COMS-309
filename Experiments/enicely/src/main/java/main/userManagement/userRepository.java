package main.userManagement;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface userRepository extends JpaRepository<userData, Long>
{
    userData findById(int id);

    userData findByUsername(String username);

    @Transactional
    void deleteById(int id);
}
