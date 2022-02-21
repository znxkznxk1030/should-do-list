docker-compose down

# cd should-do-app/
# npm run build
# cd ..

cd client-service/
mvn clean package
cd ..


cd todo-service/
mvn clean package
cd ..


docker-compose build
docker-compose up -d

docker-compose logs -f