@SpringBootApplication
public class StudentServiceApp { public static void main(String[] a) { SpringApplication.run(StudentServiceApp.class,a); } }
@RestController @RequestMapping("/students") public class StudentController {
@GetMapping("/{id}")
public Student getStudent(@PathVariable Long id) { return new Student(id, "Arjun Kumar", "CSE");
}
}
Service 2 – Course Service (port 8082) @RestController @RequestMapping("/courses")
public class CourseController { @GetMapping("/student/{id}")
public List<String> getCoursesForStudent(@PathVariable Long id) {
return List.of("Java Programming", "Data Structures", "Cloud Computing");
}
}
Application.properties # Student Service server.port=8081
spring.application.name=student-service # Course Service
server.port=8082 spring.application.name=course-service
