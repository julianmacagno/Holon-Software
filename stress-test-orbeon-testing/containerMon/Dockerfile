FROM golang:1.14.3-stretch
RUN curl -f https://get.docker.com >/tmp/get.docker.com.sh \
    && sh </tmp/get.docker.com.sh
WORKDIR /containermon/
COPY go.mod /containermon/
COPY go.sum /containermon/
COPY main.go /containermon/
CMD ["bash"]