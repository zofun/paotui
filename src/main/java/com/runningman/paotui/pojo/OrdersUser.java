package com.runningman.paotui.pojo;

import lombok.*;

/**
 * @Auther: http://www.tanwei.com
 * @Date: 2019/10/31
 * @Description: com.runningman.paotui.pojo
 * @versio: 1.0
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrdersUser {
    private int id;
    private String title;
    private String begin;
    private String end;
    private String reward;
    private String status;
}
