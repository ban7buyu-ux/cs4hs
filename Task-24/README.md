Prompt v1
"Make a REST API for students"
Output: Basic controller with no validation, no error handling. Score: 5/10
Prompt v2 (Refined)
"Create a Spring Boot REST API for student management with:
-	CRUD operations
-	Input validation (@Valid)
-	Global exception handling
-	JPA with MySQL"
Output: Complete controller + entity + exception handler. Score: 8/10
Prompt v3 (Production-Ready)
"Create a production-ready Spring Boot REST API for students with:
-	CRUD with proper HTTP status codes (201, 204, 404)
-	Bean Validation with custom error messages
-	Global @ControllerAdvice exception handling
-	Spring Security with JWT authentication
-	Dockerfile for containerization
-	AWS deployment steps (EC2 + RDS)" Output: Complete production-grade application. Score: 10/10
Generated Dockerfile & AWS Deployment # Dockerfile (AI Generated)
FROM eclipse-temurin:17-jdk-alpine
 
WORKDIR /app
COPY target/student-service.jar app.jar EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"] # AWS Deployment Steps (AI Generated) # 1. Build and push to ECR
aws ecr get-login-password --region ap-south-1 | \
docker login --username AWS --password-stdin 123456789.dkr.ecr.ap-south- 1.amazonaws.com
docker build -t student-service .
docker tag student-service:latest 123456789.dkr.ecr.ap-south-1.amazonaws.com/student- service
docker push 123456789.dkr.ecr.ap-south-1.amazonaws.com/student-service # 2. Launch EC2 and run container
docker run -d -p 8080:8080 \
-e DB_URL=jdbc:mysql://<RDS_HOST>:3306/studentdb \
-e DB_USER=admin -e DB_PASS=secret \ student-service
