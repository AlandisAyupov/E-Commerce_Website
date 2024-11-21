FROM openjdk:22-oracle
ARG JAR_FILE=target/*.jar
COPY ./target/Bank-0.0.1-SNAPSHOT.jar app.jar
ENV SPRING_DATASOURCE_URL=spring.datasource.url=jdbc:mysql://host.docker.internal:3306/scheme?createDatabaseIfNotExist=true
ENV SPRING_DATASOURCE_USERNAME=spring.datasource.username=root
ENV SPRING_DATASOURCE_PASSWORD=spring.datasource.password=kUV(F@73eugdw
ENTRYPOINT ["java", "-jar", "/app.jar"]