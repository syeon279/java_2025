FROM openjdk:11
WORKDIR /app
COPY build/ROOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]