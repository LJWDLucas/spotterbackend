FROM openjdk:11-jre

COPY target/spotter-backend-1.0-SNAPSHOT-jar-with-dependencies.jar /opt/binaries/spotter-backend-1.0-SNAPSHOT-jar-with-dependencies.jar

COPY Spotter.db /opt/binaries

EXPOSE 4567

WORKDIR /opt

# start on run
CMD ["java", "-jar", "/opt/binaries/spotter-backend-1.0-SNAPSHOT-jar-with-dependencies.jar"]

RUN docker run -p 4567:4567 spotter
