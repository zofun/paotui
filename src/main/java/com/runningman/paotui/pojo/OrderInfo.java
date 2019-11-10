package com.runningman.paotui.pojo;

import lombok.*;

import java.util.Date;

/**
 * @Auther: http://www.tanwei.com
 * @Date: 2019/11/5
 * @Description: com.runningman.paotui.pojo
 * @versio: 1.0
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfo {
    private String username;
    private String name;
    private String title;
    private String info;
    private String begin;
    private String end;
    private String reward;
    private String start_Lnglat;
    private String end_lnghat;
    private Date endtime;
}
