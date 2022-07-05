package com.lkh.easyevent_01.fetcher;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lkh.easyevent_01.entity.UserEntity;
import com.lkh.easyevent_01.service.UserService;
import com.lkh.easyevent_01.type.Event;
import com.lkh.easyevent_01.type.User;
import com.lkh.easyevent_01.type.input.InputUser;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author lkh
 * @create 2022-07-05-15:36
 */
@DgsComponent
public class UserDataFetcher {
    @Autowired
    UserService userService;

    @DgsQuery
    public List<User> listUser(){
        return User.outputListToUserList(userService.list());
    }

    @DgsMutation
    public String createUser(@InputArgument("user") InputUser inputUser){
        if(isUsedEmail(inputUser)){
            throw new RuntimeException("邮箱已被使用！");
        }
        UserEntity userEntity = UserEntity.inputConvertToEntity(inputUser);
        userService.save(userEntity);
        return "OK";
    }

    private boolean isUsedEmail(InputUser inputUser) {
        LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserEntity::getEmail,inputUser.getEmail());
        if(userService.getBaseMapper().selectCount(queryWrapper)>= 1){
            return true;
        }else {
            return false;
        }
    }
}
