package com.college.dao;

import com.college.domain.Message;

import java.util.List;
import java.util.Map;

/*
* 文档
* */
public interface MessageDao {
    //根据条件查找
    List<Message> getMessage(Map map);
    //查找所有
    List<Message> getAllMessage();
    //插入
    int insertMessage(Map map);
    //删除
    int deleteMessage(Map map);
    //更新
    int updateMessage(Map map);

}
