package com.lkh.easyevent_01.type.input;

import lombok.Data;

/**
 * 与schema文件中的类型进行对应
 * @author lkh
 * @create 2022-07-04-17:44
 */
@Data
public class InputEvent {
    private String title;
    private String des;
    private Double price;
    private String date;
    private Integer creatorId;
}
