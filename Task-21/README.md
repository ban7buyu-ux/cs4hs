GitHub Actions Workflow (.github/workflows/ci.yml) name: Spring Boot CI/CD Pipeline
on:
push:
branches: [ main ] pull_request:
branches: [ main ] jobs:
build-and-test:
runs-on: ubuntu-latest steps:
-	name: Checkout code uses: actions/checkout@v3
-	name: Set up JDK 17
uses: actions/setup-java@v3 with:
java-version: '17' distribution: 'temurin'
-	name: Build with Maven
run: mvn clean package -DskipTests
-	name: Run Tests run: mvn test
-	name: Upload JAR artifact
uses: actions/upload-artifact@v3 with:
name: student-service-jar path: target/*.jar
 
deploy:
needs: build-and-test runs-on: ubuntu-latest steps:
-	name: Deploy to server run: |
echo "Deploying application..."
# scp target/*.jar user@server:/app/
# ssh user@server 'systemctl restart student-service'

