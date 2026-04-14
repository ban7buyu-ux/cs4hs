// StudentRepository.java
import org.springframework.data.domain.*; import org.springframework.data.jpa.repository.*;
public interface StudentRepository extends JpaRepository<Student, Long> {
// Filter by department
List<Student> findByDepartment(String department);
// Pagination and sorting
Page<Student> findByDepartment(String department, Pageable pageable);
// Custom query by age (derived from dob)
@Query("SELECT s FROM Student s WHERE YEAR(NOW()) - YEAR(s.dob) > :age") List<Student> findStudentsOlderThan(@Param("age") int age);
}
// StudentService.java @Service
public class StudentService { @Autowired StudentRepository repo;
public Page<Student> getByDeptPaged(String dept, int page, int size) { Pageable pg = PageRequest.of(page, size, Sort.by("name").ascending()); return repo.findByDepartment(dept, pg);
}
public List<Student> getOlderThan(int age) { return repo.findStudentsOlderThan(age);
}
}
