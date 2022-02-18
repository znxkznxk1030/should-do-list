# spring-kata-1
spring kata 1


## Build

```bash
mvn package:repackage
```

## Volume 설정

### docker-compose.yml

- 공백에 예민하니 todo-data:[공백]/var/lib.mysql에서 [공백]을 꼭 없애야 한다.

```yml
  mysql:
    ...
    volumes:
      - todo-data:/var/lib/mysql

volumes:
  todo-data:
```

### inspect

```bash
docker volume ls
docker volume inspect spring-kata-1_todo-data
```
