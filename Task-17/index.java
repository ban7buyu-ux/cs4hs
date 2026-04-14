// CourseService.java – calls Student Service @Service
public class CourseService {
private final WebClient webClient;
public CourseService(WebClient.Builder builder) { this.webClient = builder
.baseUrl("http://student-service")
.build();
}
public StudentDTO getStudentInfo(Long studentId) { return webClient.get()
.uri("/students/{id}", studentId)
.retrieve()
.onStatus(HttpStatus::is4xxClientError,
resp -> Mono.error(new RuntimeException("Student not found")))
.bodyToMono(StudentDTO.class)
.block();
}
}
// CourseController.java @GetMapping("/courses/with-student/{id}")
public Map<String, Object> getCourseWithStudent(@PathVariable Long id) { StudentDTO student = courseService.getStudentInfo(id);
return Map.of( "student", student,
"courses", List.of("Java", "DSA", "Cloud")
 
);
}



