package userlist;

import java.util.Objects;

public class Users {

    private String login;
    private String password;
    private int age;
    private String gender;
    private String firstName;
    private String lastName;
    private String deskcription;

    public Users(String login, String password) {
        this.login = login;
        this.password =password;
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

    public void setPassword(String passvord) {
        this.password = passvord;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getDeskcription(String description) {
        return deskcription;
    }

    public void setDeskcription(String deskcription) {
        this.deskcription = deskcription;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", passvord='" +password + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", deskcription='" + deskcription + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users user = (Users) o;
        return age == user.age &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                gender == user.gender &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(deskcription, user.deskcription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, age, gender, firstName, lastName, deskcription);
    }




}


