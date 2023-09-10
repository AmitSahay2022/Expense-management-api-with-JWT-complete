package com.youtube.springbasicsecurity.entity;

import lombok.Data;

@Data
public class LoginModel {
  private String usernameOrEmail;
  private String password;
}
