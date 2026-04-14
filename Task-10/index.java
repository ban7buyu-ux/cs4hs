// Student.java
import jakarta.persistence.*; @Entity
@Table(name = "students") public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
@Column(name = "name", nullable = false) private String name; @Column(name = "email", unique = true) private String email; @Column(name = "dept")	private String department;
// Getters and Setters omitted for brevity
}
// StudentRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
public interface StudentRepository extends JpaRepository<Student, Long> {}
// StudentController.java @RestController @RequestMapping("/students") public class StudentController {
@Autowired StudentRepository repo;
@GetMapping	public List<Student> getAll()	{ return repo.findAll(); } @PostMapping public Student	create(@RequestBody Student s) { return repo.save(s); }
@PutMapping("/{id}") public Student update(@PathVariable Long id, @RequestBody Student s) { s.setId(id); return repo.save(s);
}
 
@DeleteMapping("/{id}") public String delete(@PathVariable Long id) { repo.deleteById(id); return "Deleted";
}
}

