FROM anapsix/alpine-java:latest
VOLUME /tmp
ADD discovery-server-*.jar discovery-server.jar
RUN sh -c 'touch /discovery-server.jar'
ENV JAVA_OPTS="-Xmx256m -XX:+ExitOnOutOfMemoryError"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /discovery-server.jar" ]
