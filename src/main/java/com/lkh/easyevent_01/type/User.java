package com.lkh.easyevent_01.type;

import com.lkh.easyevent_01.entity.UserEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lkh
 * @create 2022-07-05-15:23
 */
@Data
public class User {
    private Integer id;
    private String email;
    private String password;

    public static User outputToUser(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setEmail(userEntity.getEmail());
        user.setPassword(userEntity.getPassword());
        return user;
    }

    public static List<User> outputListToUserList(List<UserEntity> list) {
        List<User> result = new ArrayList<>();
        for (UserEntity userEntity : list) {
            User event = outputToUser(userEntity);
            result.add(event);
        }
        return result;
    }
}
