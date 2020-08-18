package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь


        // Классы dao/service должны реализовывать соответствующие интерфейсы
        // Класс dao должен иметь конструктор пустой/по умолчанию
        // Все поля должны быть private
        // service переиспользует методы dao
        // Обработка всех исключений, связанных с работой с базой данных должна находиться в dao
        // Класс Util должен содержать логику настройки соединения с базой данных

        UserService userService = new UserServiceImpl();
        userService.createUsersTable();

    }


}
