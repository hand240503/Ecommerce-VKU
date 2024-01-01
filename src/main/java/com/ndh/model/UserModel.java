package com.ndh.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel extends AbstractModel<UserModel> {

    private String userName;

    private String password;

    private Integer role;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String hashedPassword;

    private Integer status;

    private String email;

    private int countChangePassword;

    @Override
    public String toString() {
        return "UserModel{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hashedPassword='" + hashedPassword + '\'' +
                ", status=" + status +
                ", email='" + email + '\'' +
                '}';
    }
}
