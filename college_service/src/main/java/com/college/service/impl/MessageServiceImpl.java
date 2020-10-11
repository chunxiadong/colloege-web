package com.college.service.impl;

import com.college.dao.MessageDao;
import com.college.domain.Message;
import com.college.service.MessageService;
import com.college.utils.SetLogUtil;
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
}
