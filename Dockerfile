FROM openjdk:17
COPY monoliet/target/monoliet-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]