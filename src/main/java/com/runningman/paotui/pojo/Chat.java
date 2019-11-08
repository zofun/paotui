package com.runningman.paotui.pojo;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Chat {
    private Integer id;
    private String sender;
    private String addressee;
    private Date time;
    private String info;
    private String status;
}
