package userlist;

import Dao.impl.BaseDaoImpl;

import java.sql.SQLException;
import java.util.Scanner;


public class Run {

    public static void main(String[] args) throws SQLException {
        BaseDaoImpl user = new BaseDaoImpl() {
            @Override
            public void add(Object model) {
            }

            @Override
            public void show(String login, Object model) {
            }
        };
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите опрецию ктоорую хотите произвести:\n" +
                "1. добавить юзера\n" +
                "2. вывести список юзеров\n" +
                "3. войти в аккаунт\n " +
                "Press inter ");
        int number = scanner.nextInt();
        switch (number) {
            case 1:
                user.add();
                break;
            case 2:
                System.out.println("таблица users");
                user.show();
                break;
            case 3:
                System.out.println(" Вы в системе, Press enter ");
                user.enter();
                break;
        }
        scanner.close();
    }
}


