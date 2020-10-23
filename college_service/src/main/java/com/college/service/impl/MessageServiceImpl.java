package com.college.service.impl;

import com.college.dao.MessageDao;
import com.college.domain.Message;
import com.college.service.MessageService;
import com.college.utils.SetLogUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MessageServiceImpl implements MessageService {
    static{
        SetLogUtil.setLog(MessageServiceImpl.class).info("==进入MessageServiceImpl===");
    }
  @Autowired
    private MessageDao messageDao;//调用的是

    public void setMessageDao(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Override
    public List<Message> getMessage(Map map) {
        return messageDao.getMessage(map);
    }

    @Override
    public List<Message> getAllMessage() {
        return messageDao.getAllMessage();
    }

    @Override
    public int insertMessage(Map map) {
        return messageDao.insertMessage(map);
    }

    @Override
    public int deleteMessage(Map map) {
        return messageDao.deleteMessage(map);
    }

    @Override
    public int updateMessage(Map map) {
        return messageDao.updateMessage(map);
    }

    @Override
    public PageInfo<Message> getAllMessageByPage(Integer page, Integer rows) {
        //分页
        PageHelper.startPage(page,rows);
        List<Message> list=messageDao.getAllMessage();//调用查询语句
        PageInfo<Message> pageInfo=new PageInfo(list);
        return  pageInfo;
    }
}
