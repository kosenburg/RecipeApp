FROM openjdk:8-jre

ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/myservice/myservice.jar"]

# Add the service itself
ARG JAR_FILE=target/recipeapp-1.0.0.jar
ADD target/${JAR_FILE} /usr/share/myservice/myservice.jar