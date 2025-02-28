FROM eclipse-temurin:17-jdk-focal
RUN groupadd -r spring && useradd -r -g spring spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
RUN chown spring:spring app.jar
USER spring
ENTRYPOINT ["java","-jar","/app.jar"]




