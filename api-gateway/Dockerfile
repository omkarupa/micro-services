FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY target/api-gateway.jar api-gateway.jar

EXPOSE 8765:8765

ENTRYPOINT [ "java","-jar","api-gateway.jar" ]