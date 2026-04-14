Prompt Engineering Techniques Technique 1: Zero-Shot Prompt
Prompt: "Write a Spring Boot REST controller for managing products with GET, POST, PUT, DELETE endpoints."
Technique 2: Few-Shot Prompt (with examples)
@Entity public class Student { @Id Long id; String name; } Now generate a similar Product entity with fields:
id, name, price (decimal), stock (int)." Technique 3: Chain-of-Thought Prompt Prompt: "Think step by step:
Step 1: Create a MySQL table for orders. Step 2: Write JPA entity class.
Step 3: Write Spring Data JPA repository. Step 4: Write REST controller.
Generate all four components." Technique 4: Role Prompt
Prompt: "You are a senior Java architect. Review this code and suggest improvements for scalability and security:
[paste code here]"
Technique 5: Cloud Config Template Prompt
Prompt: "Generate an AWS CloudFormation template for:
-	EC2 instance (t3.micro)
-	S3 bucket with versioning enabled
-	RDS MySQL instance (db.t3.micro)
-	Security groups allowing port 8080 and 3306"
