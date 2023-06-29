FROM eclipse-temurin:17.0.7_7-jre-ubi9-minimal

WORKDIR /app

COPY target/docker.superheroes.example-0.0.1-SNAPSHOT.jar /app/docker-superheroes-example.jar

ENTRYPOINT ["java", "-jar", "docker-superheroes-example.jar"]
