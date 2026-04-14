// GatewayApp.java @SpringBootApplication public class GatewayApp {
public static void main(String[] args) { SpringApplication.run(GatewayApp.class, args);
}
}
# application.yml – API Gateway server:
port: 8080 spring:
cloud:
gateway:
routes:
-	id: student-service
uri: lb://student-service	# lb = load balanced predicates:
-	Path=/students/**
-	id: course-service
uri: lb://course-service predicates:
-	Path=/courses/**
eureka:
client:
service-url:
defaultZone: http://localhost:8761/eureka/

