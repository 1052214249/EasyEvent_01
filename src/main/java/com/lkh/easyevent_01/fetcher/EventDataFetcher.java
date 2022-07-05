package com.lkh.easyevent_01.fetcher;


import com.lkh.easyevent_01.entity.EventEntity;
import com.lkh.easyevent_01.entity.UserEntity;
import com.lkh.easyevent_01.service.EventService;
import com.lkh.easyevent_01.service.UserService;
import com.lkh.easyevent_01.type.Event;
import com.lkh.easyevent_01.type.User;
import com.lkh.easyevent_01.type.input.InputEvent;
import com.netflix.graphql.dgs.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lkh
 * @create 2022-07-04-14:54
 */
@DgsComponent
public class EventDataFetcher {
    @Autowired
    EventService eventService;
    @Autowired
    UserService userService;

    /**
     * 表示这是个查询操作
     *
     * @return
     */
    @DgsQuery
    public List<Event> listEvents() {
        List<EventEntity> list = eventService.list();
        List<Event> events = list.stream().map(Event::outputToEvent).collect(Collectors.toList());
        return events;
    }

    /**
     * 表示这是个增删改操作
     * 其中入参需要用@InputArgument注解，参数名需要与schema中的入参名对应，如果不对应，则可以在注解中使用name属性指定
     *
     * @return
     */
    @DgsMutation
    public String createEvent(@InputArgument InputEvent event) {
        EventEntity eventEntity = EventEntity.inputConvertToEntity(event);
        eventService.save(eventEntity);
        return "OK";
    }

    /**
     * 使用Dgs自带的解析器来填充所需要类的子类
     * DgsData表示这是一个解析器，当前端会使用到子类中的某个字段时，解析器会自动把子类填充到父类中
     * parentType表示此属性属于那个类，field表示属于类的哪个字段
     * DgsDataFetchingEnvironment是dgs的上下文环境
     * @param dfe
     * @return
     */
    @DgsData(parentType = "Event",field = "creator")
    public User getThisUser(DgsDataFetchingEnvironment dfe){
        //首先从DgsDataFetchingEnvironment获取所需的类
        Event event = dfe.getSource();
       return User.outputToUser(userService.getById(event.getCreatorId()));
    }

//    /**
//     * 使用传统的办法填充Event中的User，此时不管前端需不需要User属性都会去查数据库
//     * @param event
//     * @param creatorId
//     */
//    private void setUserIntoEvent(Event event,Integer creatorId){
//        UserEntity userEntity = userService.getById(creatorId);
//        if(userEntity == null){
//            throw new RuntimeException("用户不存在！");
//        }
//        event.setCreator(User.outputToUser(userEntity));
//    }
}
