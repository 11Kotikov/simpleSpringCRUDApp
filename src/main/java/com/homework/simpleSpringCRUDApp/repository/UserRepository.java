package com.homework.simpleSpringCRUDApp.repository;

import com.homework.simpleSpringCRUDApp.model.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Data
public class UserRepository {
    @Autowired
    private final JdbcTemplate jdbcTemplate; //  jdbcTemplate является объектом взаимодействующим с БД.

    /**
     * Метод findUserById() возвращает пользователя из БД по его id.
     *
     * @param id - id пользователя.
     * @return пользователь.
     */

    public User findUserById(int id) {
        List<User> userList = jdbcTemplate.query("SELECT * FROM users WHERE id = ?", new Object[]{id}, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            return user;
        });

        if (userList.isEmpty()) {
            return null;
        } else {
            return userList.get(0);
        }
    }


    /**
     * Метод findAll() возвращает список всех пользователей из БД.
     *
     * @return список пользователей.
     */

    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM users", (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            return user;
        });
    }

    /**
     * Метод save() сохраняет пользователя в БД.
     *
     * @param user - пользователь для сохранения.
     * @return сохраненный пользователь.
     */
    public User save(User user) {
        jdbcTemplate.update("INSERT INTO users (id, first_name, last_name) VALUES (NULL, ?, ?)",
                user.getFirstName(), user.getLastName());
        return user;
    }

    /**
     * Метод deleteUserById() удаляет пользователя из БД по его id.
     *
     * @param id - уникальный id пользователя для удаления.
     */
    public void deleteUserById(int id) {
        jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);
    }

    /**
     * Метод updateUser() обновляет данные пользователя в БД.
     *
     * @param user - пользователь для обновления.
     */
    public void updateUser(User user) {
        jdbcTemplate.update("UPDATE users SET first_name = ?, last_name = ? WHERE id = ?",
                user.getFirstName(), user.getLastName(), user.getId());
    }
}
