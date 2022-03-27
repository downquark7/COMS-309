package backend.instructors;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Integer>
{
    public Instructor findByInstrName(String instrName);
}
