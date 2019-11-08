package com.runningman.paotui.pojo;

import lombok.*;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.util.Date;

/**
 * @Auther: http://www.tanwei.com
 * @Date: 2019/10/31
 * @Description: com.runningman.paotui.pojo
 * @versio: 1.0
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Status {
    private int id;
    private int order_id;
    private String info;
    private Date time;
}
