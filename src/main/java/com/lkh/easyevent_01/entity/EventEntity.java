package com.lkh.easyevent_01.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lkh.easyevent_01.type.input.InputEvent;
import com.lkh.easyevent_01.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author lkh
 * @create 2022-07-05-10:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_event") //如果表名和类名一样，则此注解可加可不加
public class EventEntity {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField
    private String title;

    @TableField
    private String des;

    @TableField
    private Double price;

    @TableField
    private Date date;

    @TableField
    private Integer creatorId;

    public static EventEntity inputConvertToEntity(InputEvent inputEvent){
        EventEntity eventEntity = new EventEntity();
        eventEntity.setDes(inputEvent.getDes());
        eventEntity.setPrice(inputEvent.getPrice());
        eventEntity.setTitle(inputEvent.getTitle());
        eventEntity.setDate(DateUtil.formatToDate(inputEvent.getDate()));
        eventEntity.setCreatorId(inputEvent.getCreatorId());
        return eventEntity;
    }

}
