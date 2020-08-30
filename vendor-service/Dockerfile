FROM amazoncorretto:11 AS builder
WORKDIR /develop/
COPY . /develop/
RUN /develop/mvnw package

FROM amazoncorretto:11-alpine
#RUN apk --no-cache add ca-certificates
WORKDIR /release/
COPY --from=builder /develop/target/vendor-service-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "/release/vendor-service-0.0.1-SNAPSHOT.jar"]
