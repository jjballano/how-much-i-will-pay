#!/bin/sh
docker build . -t kuanto-renta
mkdir -p build
docker run --rm --entrypoint cat kuanto-renta  /home/application/function.zip > build/function.zip

sam local start-api -t sam.yaml -p 3000

