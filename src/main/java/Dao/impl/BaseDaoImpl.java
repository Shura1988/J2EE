package Dao.impl;

import Dao.BaseDao;
import userlist.Connect;
import userlist.Sex;
import userlist.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class BaseDaoImpl implements BaseDao {

    Connect connection = new Connect();
    Statement st;
    {
        try {
           st = connection.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void add() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        String str2 = "INSERT INTO user (login, password, age, sex, firstName, lastName, description) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps1 = connection.getConnection().prepareStatement(str2);
        System.out.println("Введите логин:  ");
        String login = scanner.next();

        boolean flag = true;
        while (flag) {
            String query = "select * from user where login ='" + login + "';";
            if (st.executeQuery(query).next()) {
                System.out.println("Такой login существует, введите новый");

                login = scanner.next();
            } else {
                flag = false;
            }
        }
        ps1.setString(1, login);
        System.out.println("Введите пароль:  ");
        String password = scanner.next();
        ps1.setString(2, password);
        System.out.println("Введите возраст:  ");
        int age = scanner.nextInt();
        if (age < 0) {
            System.out.println("Неправильно указан возраст");
            System.out.println("Введите возраст");
            age = scanner.nextInt();
        } else {
            age = age;
        }
        ps1.setInt(3, age);
        System.out.println("Введите пол:  ");
        System.out.println(" 1 - man;\n 2 - woman");
        int sex = scanner.nextInt();
        if (sex == 1) {
            ps1.setString(1, String.valueOf(sex));
        } else if (sex == 2) {
            ps1.setString(2, String.valueOf(sex));
        } else {
            System.out.println("Некорректное значение");
        }

        ps1.setInt(4, sex);
        System.out.println("Введите firstName:  ");
        String firstName = scanner.next();
        ps1.setString(5, firstName);
        System.out.println("Введите lastName:  ");
        String lastName = scanner.next();
        ps1.setString(6, lastName);
        System.out.println("Введите иформацию о себе:  ");
        String description = scanner.next();
        ps1.setString(7, description);
        ps1.executeUpdate();
        System.out.println("User добавлен");
        scanner.close();
        st.close();

    }

    @Override
    public void show() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String str = "SELECT * from User";
        ResultSet rs1 = st.executeQuery(str);
        while (rs1.next()) {
            List<Users> users = new ArrayList<>();
            Users user = new Users();
            user.setLogin(rs1.getString("login"));
            user.setPassword(rs1.getString("password"));
            user.setAge(rs1.getInt("age"));
            user.setSex(Sex.valueOf(rs1.getString("sex")));
            user.setFirstName(rs1.getString("firstName"));
            user.setLastName(rs1.getString("lastName"));
            user.setDeskcription(rs1.getString("description"));
            users.add(user);
            System.out.println(users);
        }
        scanner.close();
        st.close();
    }

    @Override
    public void enter() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();
        try {

            String query = "select * from user where login ='" + login + "' and password ='" + password + "';";
            if (st.executeQuery(query).first()) {
                System.out.println("Добро пожаловать");

                System.out.println("1. Инфо");
                int x1 = scanner.nextInt();
                if (x1 == 1) show();
                else System.exit(0);
            } else {
                System.out.println("Неверный логин/пароль" + '\n' + "Нажмите любую клавишу");
                enter();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        scanner.close();
    }

}
