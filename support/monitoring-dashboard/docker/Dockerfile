FROM anapsix/alpine-java:latest
VOLUME /tmp
ADD monitoring-dashboard-*.jar monitoring-dashboard.jar
RUN sh -c 'touch /monitoring-dashboard.jar'
ENV JAVA_OPTS="-Xmx256m -XX:+ExitOnOutOfMemoryError"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /monitoring-dashboard.jar" ]
