package com.runningman.paotui.pojo;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @Auther: http://www.tanwei.com
 * @Date: 2019/11/7
 * @Description: com.runningman.paotui.pojo
 * @versio: 1.0
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private int id;
    private String user;
    private int order_id;
    private String info;
    private Date time;
    private int start;
}
