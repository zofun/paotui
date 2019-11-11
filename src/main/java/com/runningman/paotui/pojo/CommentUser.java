package com.runningman.paotui.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommentUser {
    Integer id;
    String title;
    Date time;
    String reward;
    int start;

}
