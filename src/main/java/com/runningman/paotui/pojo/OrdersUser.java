package com.runningman.paotui.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Auther: http://www.tanwei.com
 * @Date: 2019/10/31
 * @Description: com.runningman.paotui.pojo
 * @versio: 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrdersUser {
    private int id;
    private String titile;
    private String begin;
    private String end;
    private String reward;
    private String status;
}
