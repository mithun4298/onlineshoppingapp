FROM openjdk:11
EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} product-service.jar
ENTRYPOINT ["java","-jar","product-service.jar"]