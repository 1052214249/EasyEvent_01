package com.lkh.easyevent_01.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lkh.easyevent_01.entity.UserEntity;
import com.lkh.easyevent_01.mapper.UserMapper;
import com.lkh.easyevent_01.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author lkh
 * @create 2022-07-05-14:50
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {
}
