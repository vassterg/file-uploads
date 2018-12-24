# Build
mvn clean package && docker build -t gr.insurit/RestEasyUpload .

# RUN
docker rm -f RestEasyUpload || true && docker run -d -p 8080:8080 -p 4848:4848 --name RestEasyUpload gr.insurit/RestEasyUpload 
