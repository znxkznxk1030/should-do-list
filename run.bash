docker-compose down

cd auth-service/
mvn clean package
cd ..

cd todo-service/
mvn clean package
cd ..

docker-compose build
docker-compose up -d

docker-compose logs -f