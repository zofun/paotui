package com.runningman.paotui.pojo;

import lombok.*;

import java.util.Date;

/**
 * @Auther: http://www.tanwei.com
 * @Date: 2019/11/15
 * @Description: com.runningman.paotui.pojo
 * @versio: 1.0
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChatHistory {
    private String sender;
    private String addressee;
    private Date time;
    private String info;
}
