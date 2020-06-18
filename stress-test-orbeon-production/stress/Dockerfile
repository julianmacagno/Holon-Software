FROM openjdk:8
WORKDIR /orbeon
# COPY ./apache-jmeter-5.2.1/ ./apache-jmeter-5.2.1/
ADD https://apache.zero.com.ar//jmeter/binaries/apache-jmeter-5.2.1.tgz /orbeon/
RUN tar -xf apache-jmeter-5.2.1.tgz
RUN rm apache-jmeter-5.2.1.tgz
RUN rm -rf apache-jmeter-5.2.1/docs
COPY runTest.sh .
COPY ./Orbeon-Complejidad-Alta-Docker.jmx .
COPY ./Orbeon-Complejidad-Media-Docker.jmx .
COPY ./Orbeon-Complejidad-Baja-Docker.jmx .
RUN chmod +x *.sh
RUN mkdir results
