package com.ndh.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OTPModel {
    private int id;
    private Long idUser;
    private String code;
    private int status;



}
