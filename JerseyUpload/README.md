# Build
mvn clean package && docker build -t gr.insurit/JerseyUpload .

# RUN
docker rm -f JerseyUpload || true && docker run -d -p 8080:8080 -p 4848:4848 --name JerseyUpload gr.insurit/JerseyUpload 
