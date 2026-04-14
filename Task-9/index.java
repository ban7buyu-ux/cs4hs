import org.springframework.stereotype.*; import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*; @Controller
public class EmployeeController { @GetMapping("/employee")
public String showEmployee(Model model) { model.addAttribute("name", "Arjun Kumar"); model.addAttribute("dept", "CSE"); model.addAttribute("salary", "75000");
return "employeeView";
}
}
// WebConfig.java @Configuration @EnableWebMvc
@ComponentScan("com.example.mvc")
public class WebConfig implements WebMvcConfigurer { @Bean
public InternalResourceViewResolver resolver() { InternalResourceViewResolver r = new InternalResourceViewResolver(); r.setPrefix("/WEB-INF/views/");
r.setSuffix(".jsp"); return r;
}
 
}
<!-- employeeView.jsp -->
<h2>Employee Details</h2>
<p>Name: ${name}</p>
<p>Department: ${dept}</p>
<p>Salary: ₹${salary}</p>

