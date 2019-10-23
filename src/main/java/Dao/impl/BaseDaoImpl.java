package Dao.impl;

import Dao.BaseDao;
import userlist.Connect;
import userlist.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class BaseDaoImpl implements BaseDao {
    Connect connection = new Connect();
    Scanner scanner = new Scanner(System.in);

    public BaseDaoImpl() {
    }

    public void addUser() throws SQLException {

        String str1 = "INSERT INTO user (login, passvord, age, gender, firstName, lastName, description) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.getConnection().prepareStatement(str1);
        System.out.println("Введите логин:  ");
        String login = scanner.next();
        ps.setString(1, login);
        System.out.println("Введите пароль:  ");
        String password = scanner.next();
        ps.setString(2, password);
        System.out.println("Введите возраст:  ");
        int age = scanner.nextInt();
        if (age < 0) {
            System.out.println("Неправильно указан возраст");
            System.out.println("Введите возраст");
            age = scanner.nextInt();
        } else {
            age = age;
        }
        ps.setInt(3, age);
        System.out.println("Введите пол:  ");
        String gender = scanner.next();
        ps.setString(4, gender);
        System.out.println("Введите firstName:  ");
        String firstName = scanner.next();
        ps.setString(5, firstName);
        System.out.println("Введите lastName:  ");
        String lastName = scanner.next();
        ps.setString(6, lastName);
        System.out.println("Введите иформацию о себе:  ");
        String description = scanner.next();
        ps.setString(7, description);
        ps.executeUpdate();
        System.out.println("User добавлен");
        return;
    }

    public void add() throws SQLException {

        String str2 = "INSERT INTO user (login, password, age, gender, firstName, lastName, description) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Statement st = connection.getConnection().createStatement();
        PreparedStatement ps1 = connection.getConnection().prepareStatement(str2);
        System.out.println("Введите логин:  ");
        String login = scanner.next();

        String query = "select * from user where login ='" + login + "';";
        if (st.executeQuery(query).first()) {
            System.out.println("Такой login существует, введите новый");
            login = scanner.next();
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
        String gender = scanner.next();
        ps1.setString(4, gender);
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


    }


    public void show() throws SQLException {
        Statement statement = connection.getConnection().createStatement();
        String str = "select * from user";
        ResultSet rs1 = statement.executeQuery(str);
        while (rs1.next()) {
            List<Users> users = new ArrayList<>();
            Users user = new Users();
            user.setLogin(rs1.getString("login"));
            user.setPassword(rs1.getString("password"));
            user.setAge(rs1.getInt("age"));
            user.setGender(rs1.getString("gender"));
            user.setFirstName(rs1.getString("firstName"));
            user.setLastName(rs1.getString("lastName"));
            user.setDeskcription(rs1.getString("description"));
            users.add(user);
            System.out.println(users);
        }
    }

    public void enter() {
        scanner.nextLine();
        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();
        try {
            Statement statement = connection.getConnection().createStatement();
            String query = "select * from user where login ='" + login + "' and password ='" + password + "';";
            if (statement.executeQuery(query).first()) {
                System.out.println("Добро пожаловать");

                System.out.println("1. Инфо");
                int x1 = scanner.nextInt();
                if (x1 == 1) show(login, password);
                else System.exit(0);
            } else {
                System.out.println("Неверный логин/пароль" + '\n' + "Нажмите любую клавишу");
                enter();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

