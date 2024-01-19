package com.homework.simpleSpringCRUDApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SimpleSpringCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleSpringCrudApplication.class, args);
    }

    /**
     * Создание таблицы users при запуске приложения.
     * Создание таблицы можно произвести вручную, но для того чтобы она создалась при запуске приложения,
     * можно использовать функциональный интерфейс CommandLineRunner.
     * Метод должен быть аннотирован с аннотацией @Bean.
     *
     * @param jdbcTemplate - объект класса JdbcTemplate для подключения к бд.
     * @return объект (бин) типа CommandLineRunner
     */
    @Bean
    public CommandLineRunner commandLineRunner(JdbcTemplate jdbcTemplate) {
        return args -> {
            jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS users (id BIGINT AUTO_INCREMENT PRIMARY KEY, first_name VARCHAR(255), last_name VARCHAR(255))");
        };
    }

}
