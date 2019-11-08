package com.runningman.paotui.pojo;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatMsg {
    private String senderId;
    private String message;
    private String addressee;
}
