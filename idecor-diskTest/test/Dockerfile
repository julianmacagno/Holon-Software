FROM ubuntu

# Setea zona horaria

ENV TZ=America/Argentina/Cordoba
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

RUN apt-get update \
 && apt-get install -y fio \
 && rm -rf /var/lib/apt/lists/*

COPY parser.py /testDisk/
COPY test-read.ini /testDisk/
COPY test-write.ini /testDisk/

WORKDIR /testDisk

CMD ["/bin/sleep", "99999"]
