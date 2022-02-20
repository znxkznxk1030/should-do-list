package me.arthur.todo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {
    "spring.datasource.url=jdbc:h2:mem:todo-db" })
class TodoApplicationTests {

	@Test
	void contextLoads() {
	}

}
