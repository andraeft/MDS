FROM openjdk:8-jre-alpine
ARG JAR_FILE
COPY payit-app/target/${JAR_FILE} /usr/payit/
WORKDIR /usr/payit
EXPOSE 8080
CMD ["java", "-jar", "payit-1.0-SNAPSHOT.jar"]