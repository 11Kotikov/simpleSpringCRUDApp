# Простое приложение на Spring Boot для управления пользователями

Это простое веб-приложение на основе Spring Boot, предназначенное для управления пользователями. Приложение использует Spring Web, Thymeleaf и базу данных H2 через JDBC.

## Основные функции

1. **Создание пользователя:** Приложение позволяет создавать новых пользователей, вводя их имя и фамилию через веб-интерфейс.

2. **Просмотр списка пользователей:** Существующие пользователи отображаются на главной странице приложения.

3. **Редактирование пользователя:** Пользователи могут быть отредактированы, изменяя их имя и фамилию через соответствующую форму.

4. **Удаление пользователя:** Пользователи могут быть удалены с подтверждением через отдельную страницу.

## Технологии и инструменты

- Spring Boot
- Spring Web
- Thymeleaf
- H2 Database (JDBC)
- Maven

## Запуск приложения

1. Клонировать репозиторий:

    ```bash
    git clone https://github.com/your-username/your-repository.git
    ```

2. Перейти в каталог приложения:

    ```bash
    cd your-repository
    ```

3. Запустить приложение:

    ```bash
    mvn spring-boot:run
    ```

4. Открыть браузер и перейти по адресу: [http://localhost:8080/users](http://localhost:8080/users)

## Конфигурация базы данных

Приложение использует базу данных H2 в режиме встроенной базы данных. Настройки базы данных можно изменить в файле `application.properties`.

```properties
# Настройки базы данных H2
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.datasource.platform=h2
spring.h2.console.enabled=true
