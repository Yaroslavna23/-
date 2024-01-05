FROM openjdk:17
ARG JAR_FILE=*.war
COPY ${JAR_FILE} application.war
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "application.war"]