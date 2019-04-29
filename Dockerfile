FROM openjdk:8
ADD target/microservices-final.jar microservices-final.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "order-service.jar"]