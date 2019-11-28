package com.runningman.paotui.pojo;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LeaveWord {
    private String name;
    private String username;
    private int count;
}
