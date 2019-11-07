package com.runningman.paotui.pojo;

import lombok.*;
import org.springframework.messaging.handler.annotation.SendTo;

/**
 * @Auther: http://www.tanwei.com
 * @Date: 2019/11/7
 * @Description: com.runningman.paotui.pojo
 * @versio: 1.0
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderStatus {
    private int id;
    private String info;
}
