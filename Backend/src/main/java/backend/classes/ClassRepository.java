package backend.classes;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/***
 * class_data table jpa repository
 */
public interface ClassRepository extends JpaRepository<ClassData, Integer>
{
    public List<ClassData> findAllByDepartmentTitle(String departmentTitle);
    public ClassData findByDepartmentTitleAndClassNumber(String departmentTitle, String classNumber);
}
