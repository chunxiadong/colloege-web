package com.college.service;

import com.college.domain.Message;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

//
public interface MessageService {
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
    //分页
    PageInfo<Message> getAllMessageByPage(Integer page, Integer rows);
}
