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


}
