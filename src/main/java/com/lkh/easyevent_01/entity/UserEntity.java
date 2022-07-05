package com.lkh.easyevent_01.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lkh.easyevent_01.type.input.InputEvent;
import com.lkh.easyevent_01.type.input.InputUser;
import com.lkh.easyevent_01.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lkh
 * @create 2022-07-05-14:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_user")
public class UserEntity {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField
    private String email;

    @TableField
    private String password;

    public static UserEntity inputConvertToEntity(InputUser inputUser){
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(inputUser.getEmail());
        userEntity.setPassword(inputUser.getPassword());
        return userEntity;
    }
}
