package userlist;

import java.util.Objects;

public class Users {

    private String login;
    private String password;
    private int age;
    private Enum sex;
    private String firstName;
    private String lastName;
    private String deskcription;

    public Users(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Users() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Enum getSex() {
        return sex;
    }

    public void setSex(Enum sex) {
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDeskcription() {
        return deskcription;
    }

    public void setDeskcription(String deskcription) {
        this.deskcription = deskcription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return age == users.age &&
                login.equals(users.login) &&
                password.equals(users.password) &&
                sex.equals(users.sex) &&
                firstName.equals(users.firstName) &&
                lastName.equals(users.lastName) &&
                deskcription.equals(users.deskcription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, age, sex, firstName, lastName, deskcription);
    }

    @Override
    public String toString() {
        return "Users{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", deskcription='" + deskcription + '\'' +
                '}';
    }
}
