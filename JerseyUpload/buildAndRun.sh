#!/bin/sh
mvn clean package && docker build -t gr.insurit/JerseyUpload .
docker rm -f JerseyUpload || true && docker run -d -p 8080:8080 -p 4848:4848 --name junk gr.insurit/JerseyUpload 
