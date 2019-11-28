package com.runningman.paotui.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern="yyyy-MM-dd_HH:mm:ss",timezone="GMT+8")
    private Date time;
    private String info;
}
