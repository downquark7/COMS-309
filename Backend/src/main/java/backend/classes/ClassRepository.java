package backend.classes;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassRepository extends JpaRepository<ClassData, Integer>
{
    public List<ClassData> findAllByDepartment(String department);
    public List<ClassData> findAllByDept(String dept);
    public ClassData findSpecific(String department, String number);
}
