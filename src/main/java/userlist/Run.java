package userlist;

import Dao.impl.BaseDaoImpl;

import java.sql.SQLException;
import java.util.Scanner;


public class Run extends BaseDaoImpl {
    public void start() throws SQLException {
        BaseDaoImpl user = new BaseDaoImpl() {
        };
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите опрецию ктоорую хотите произвести:\n" +
                "1. добавить юзера\n" +
                "2. показать юзера\n" +
                "3. войти в аккаунт ");
        int number = scanner.nextInt();
        switch (number) {
            case 1:
                user.add();
                break;
            case 2:
                System.out.println("показать юзера по полю login");
                user.show();
                break;
            case 3:
                System.out.println(" Вы в системе нажмите ввод");
                user.enter();
                break;
        }
        scanner.close();
    }


    public static void main(String[] args) throws SQLException {
        Run one = new Run();
        one.start();
    }
}


