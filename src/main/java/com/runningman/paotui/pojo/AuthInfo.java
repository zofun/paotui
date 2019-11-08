package com.runningman.paotui.pojo;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthInfo {

    private Integer id;
    private Integer start;
    private String realName;
    private String studentId;
    private Date time;
}
