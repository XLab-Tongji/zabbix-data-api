FROM java:openjdk-8-alpine

ADD ./build/libs/zabbix-data-api-0.0.1-SNAPSHOT.jar app.jar
ADD ./src/main/resources/application.properties  application.properties
EXPOSE 8080
VOLUME ["/home"]
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar --spring.config.location=/application.properties" ]