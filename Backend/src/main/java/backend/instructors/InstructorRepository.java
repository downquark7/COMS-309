package backend.instructors;

import org.springframework.data.jpa.repository.JpaRepository;

/***
 * instructor jpa repository interface
 */
public interface InstructorRepository extends JpaRepository<Instructor, Integer>
{
    public Instructor findByInstrName(String instrName);
}
