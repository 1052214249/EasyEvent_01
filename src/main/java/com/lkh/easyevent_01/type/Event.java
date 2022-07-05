package com.lkh.easyevent_01.type;

import com.lkh.easyevent_01.entity.EventEntity;
import com.lkh.easyevent_01.util.DateUtil;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 与schema文件中的类型进行对应
 *
 * @author lkh
 * @create 2022-07-04-17:44
 */
@Data
public class Event {
    private Integer id;
    private String title;
    private String des;
    private Double price;
    private String date;
    private User creator;
    //此字段只用于dgs解析器查询并填充到User属性，并无其他作用，具体看EventDataFetcher
    private Integer creatorId;

    public static Event outputToEvent(EventEntity eventEntity) {
        Event event = new Event();
        event.setId(eventEntity.getId());
        event.setTitle(eventEntity.getTitle());
        event.setDes(eventEntity.getDes());
        event.setPrice(eventEntity.getPrice());
        event.setDate(DateUtil.formatToString(eventEntity.getDate()));
        event.setCreatorId(eventEntity.getCreatorId());
        return event;
    }
}
