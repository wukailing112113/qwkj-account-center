FROM fabric8/java-jboss-openjdk8-jdk
EXPOSE 8003 8004
USER root
ENV LANG en_US.UTF-8
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ADD ./qwkj-account-center.jar .
CMD java -jar qwkj-account-center.jar
