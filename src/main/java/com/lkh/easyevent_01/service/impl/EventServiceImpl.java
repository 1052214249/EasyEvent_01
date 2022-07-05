package com.lkh.easyevent_01.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lkh.easyevent_01.entity.EventEntity;
import com.lkh.easyevent_01.mapper.EventMapper;
import com.lkh.easyevent_01.service.EventService;
import org.springframework.stereotype.Service;

/**
 * @author lkh
 * @create 2022-07-05-10:33
 */
@Service
public class EventServiceImpl extends ServiceImpl<EventMapper, EventEntity> implements EventService {
}
