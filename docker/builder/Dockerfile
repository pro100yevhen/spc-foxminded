FROM openjdk:21-jre-slim
ARG BUILD_PATH
COPY ./${BUILD_PATH}/*.jar app.jar
CMD java -jar /app.jar