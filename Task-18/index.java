// StudentServiceTest.java import org.junit.jupiter.api.*; import org.mockito.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*; @ExtendWith(MockitoExtension.class)
class StudentServiceTest {
@Mock StudentRepository repo; @InjectMocks StudentService service; @Test
void testGetStudentById_success() {
Student s = new Student(1L, "Arjun", "CSE"); when(repo.findById(1L)).thenReturn(Optional.of(s)); Student result = service.getById(1L); assertEquals("Arjun", result.getName()); assertEquals("CSE", result.getDepartment());
}
@Test
void testGetStudentById_notFound() { when(repo.findById(99L)).thenReturn(Optional.empty()); assertThrows(ResourceNotFoundException.class,
() -> service.getById(99L));
}
@Test
void testSaveStudent() {
Student s = new Student(null, "Priya", "ECE");
 
when(repo.save(s)).thenReturn(new Student(2L, "Priya", "ECE")); Student saved = service.save(s);
assertNotNull(saved.getId());
}
}

