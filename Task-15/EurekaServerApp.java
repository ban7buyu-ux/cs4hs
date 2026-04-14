// EurekaServerApp.java @SpringBootApplication @EnableEurekaServer
public class EurekaServerApp {
public static void main(String[] args) { SpringApplication.run(EurekaServerApp.class, args);
}
}
# application.yml – Eureka Server server:
port: 8761 eureka:
client:
register-with-eureka: false fetch-registry: false
Eureka Client (each microservice)
// StudentServiceApp.java @SpringBootApplication @EnableEurekaClient
public class StudentServiceApp { ... }


# application.yml – Student Service spring:
application:
name: student-service eureka:
 
client:
service-url:
defaultZone: http://localhost:8761/eureka/ Dynamic Lookup with DiscoveryClient @Autowired DiscoveryClient discoveryClient; public String getStudentServiceUrl() {
List<ServiceInstance> instances = discoveryClient.getInstances("student-service");
return instances.get(0).getUri().toString();
}

  
}
