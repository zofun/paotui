package com.runningman.paotui.pojo;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {
    private String username;
    private String password;
    private String name;
    private Integer auth;

}
