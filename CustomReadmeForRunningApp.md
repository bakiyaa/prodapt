
#Spring Boot REST API -/remove Endpoint

This is a Spring Boot REST API that provides a simple GET endpoint (/remove)
to remove the first and last character from a given string.

## How to Run the Application

Option 1: Using start.sh Script

1. Give execute permission (only once):
   chmod +x Scripts/start.sh

2. Run the script:
   ./Scripts/start.sh

   Or run in background:
   nohup ./Scripts/start.sh &

Option 2: Run in IntelliJ or Any IDE

1. Open the project in IntelliJ
2. Go to Run > Edit Configurations
3. Under your run configuration, set the following VM options:

   -Dspring.security.user.name=admin -Dspring.security.user.password=admin123

4. Click Apply and then Run

## Accessing the Application

Endpoint:
GET /remove?originalString=eloquent

This endpoint requires Basic Authentication.

Credentials:
Username: admin
Password: admin123

Sample Response:
loquen






