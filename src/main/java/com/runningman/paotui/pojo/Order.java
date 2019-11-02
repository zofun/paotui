package com.runningman.paotui.pojo;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Auther: http://www.tanwei.com
 * @Date: 2019/10/23
 * @Description: com.runningman.paotui.pojo
 * @versio: 1.0
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int id;  //订单id
    private String title;
    private String user;
    private String delivery;
    private String begin;
    private String end;
    private String start_Lnglat;
    private String end_lnglat;
    private String reward;
    //private Date orderTime; //下单时间

    private Date endtime;

}
