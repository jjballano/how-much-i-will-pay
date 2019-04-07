FROM oracle/graalvm-ce:1.0.0-rc14 as graalvm
COPY . /home/app/kuanto-renta
WORKDIR /home/app/kuanto-renta
RUN native-image --no-server -cp build/libs/kuanto-renta-*.jar

FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /home/app/kuanto-renta .
ENTRYPOINT ["./kuanto-renta"]
