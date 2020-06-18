FROM python:3.7.7-stretch
RUN curl -f https://get.docker.com >/tmp/get.docker.com.sh \
    && sh </tmp/get.docker.com.sh
WORKDIR /monitor
COPY monitor.py .
RUN mkdir stats
CMD ["bash"]