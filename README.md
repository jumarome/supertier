# Build
mvn clean package && docker build -t com.gt/super-tier .

# RUN

docker rm -f super-tier || true && docker run -d -p 8080:8080 -p 4848:4848 --name super-tier com.gt/super-tier 