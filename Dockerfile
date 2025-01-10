FROM openjdk:22-oracle
COPY ./target/Bank-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 3306
EXPOSE 27018
ENTRYPOINT ["java", "-jar", "app.jar", "com.ayupov.Bank.Application"]