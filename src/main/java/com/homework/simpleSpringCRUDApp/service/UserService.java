package com.homework.simpleSpringCRUDApp.service;

import com.homework.simpleSpringCRUDApp.model.User;
import com.homework.simpleSpringCRUDApp.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository; //userRepository - объект репозитория для работы с данными.

    /**
     * Метод getUserById() возвращает конкретного пользователя из БД по его id.
     *
     * @param id - id пользователя.
     * @return пользователь из БД.
     */
    public User getUserById(int id) {
        return userRepository.findUserById(id);
    }

    /**
     * Метод getAllUsers() возвращает список всех пользователей из БД.
     *
     * @return
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Метод saveUser() сохраняет пользователя в БД.
     *
     * @param user - пользователь для сохранения.
     * @return сохраненный пользователь.
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Метод deleteUser() удаляет пользователя из БД по его id.
     *
     * @param id - id пользователя для удаления.
     */
    public void deleteUser(int id) {
        userRepository.deleteUserById(id);
    }

    /**
     * Метод updateUser() обновляет данные пользователя в БД.
     *
     * @param user - пользователь для обновления.
     */
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }
}
