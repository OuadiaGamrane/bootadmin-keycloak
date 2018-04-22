FROM anapsix/alpine-java:latest
VOLUME /tmp
ADD gateway-server-*.jar gateway-server.jar
RUN sh -c 'touch /gateway-server.jar'
ENV JAVA_OPTS="-Xmx256m -XX:+ExitOnOutOfMemoryError"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /gateway-server.jar" ]
