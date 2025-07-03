#!/bin/bash

Copy and paste

# Spring Boot App Runner Script

# Set custom Spring Security credentials
export SPRING_SECURITY_USER_NAME=admin
export SPRING_SECURITY_USER_PASSWORD=admin123

# Optional: Set JVM or application-specific properties
export JAVA_OPTS="-Xms256m -Xmx512m"

# Run Spring Boot application using Maven
echo "Starting Spring Boot application with credentials..."
mvn spring-boot:run -Dspring-boot.run.arguments=--spring.security.user.name=$SPRING_SECURITY_USER_NAME,--spring.security.user.password=$SPRING_SECURITY_USER_PASSWORD
