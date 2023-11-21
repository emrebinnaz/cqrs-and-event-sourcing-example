FROM maven:3.8.6-eclipse-temurin-17-alpine as build-stage
ENV MAVEN_OPTS="-XX:+TieredCompilation -XX:TieredStopAtLevel=1"

WORKDIR /opt/product-query
COPY pom.xml .
COPY ./src ./src
RUN mvn clean install -Dmaven.test.skip=true


FROM eclipse-temurin:17.0.5_8-jre-alpine
WORKDIR /opt/product-query
COPY --from=build-stage /opt/product-query/target/product-query.jar /opt/product-query
ENTRYPOINT ["java", "-jar", "product-query.jar"]