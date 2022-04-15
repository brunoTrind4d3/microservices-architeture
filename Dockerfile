
ARG BUILD_IMAGE=maven:3.5-jdk-11
ARG RUNTIME_IMAGE=openjdk:11-jdk-slim

FROM ${BUILD_IMAGE} as dependencies
WORKDIR /opt/app
COPY pom.xml .
COPY microservices-application/pom.xml /opt/app/microservices-application/pom.xml
COPY microservices-domain/pom.xml /opt/app/microservices-domain/pom.xml
COPY microservices-repository/pom.xml /opt/app/microservices-repository/pom.xml
COPY microservices-rest/pom.xml /opt/app/microservices-rest/pom.xml

RUN mvn -B -e -C dependency:go-offline


FROM dependencies as build
WORKDIR /opt/app

COPY --from=dependencies /root/.m2 /root/.m2
COPY --from=dependencies /opt/app /opt/app

COPY microservices-application/src /opt/app/microservices-application/src
COPY microservices-rest/src /opt/app/microservices-rest/src
COPY microservices-domain/src /opt/app/microservices-domain/src
COPY microservices-repository/src /opt/app/microservices-repository/src


RUN mvn -B -e clean package

FROM ${RUNTIME_IMAGE}

WORKDIR /opt/app
COPY --from=build /opt/app/ .
EXPOSE 8080

CMD ["java", "-jar", "/opt/app/microservices-application/target/microservices-application-1.0.4.jar"]

