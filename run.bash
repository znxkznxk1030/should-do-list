docker-compose down

cd kata-1/
mvn clean package

cd ..

docker-compose build
docker-compose up -d

docker-compose logs -f