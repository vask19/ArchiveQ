FROM openjdk:17-jdk-slim

LABEL description="gateway"
LABEL provider="vask19"

RUN mkdir /opt/gateway
WORKDIR /opt/gateway

COPY target/gateway.jar /opt/gateway/gateway.jar
RUN chmod 755 /opt/gateway/gateway.jar

EXPOSE 8888
USER 185

ENTRYPOINT ["java", "-jar", "/opt/gateway/gateway.jar"]
