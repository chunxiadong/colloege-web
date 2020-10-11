package com.college.service.impl;

import com.college.dao.Student_Affairs_OfficeDao;
import com.college.domain.Student_Affairs_Office;
import com.college.service.Student_Affairs_OfficeService;
import com.college.utils.SetLogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Student_Affairs_OfficeServiceImpl implements Student_Affairs_OfficeService {
    static{
        SetLogUtil.setLog(Student_Affairs_OfficeServiceImpl.class).info("==进入Student_Affairs_OfficeServiceImpl===");
    }
    @Autowired
    private Student_Affairs_OfficeDao student_affairs_officeDao;
    @Override
    public List<Student_Affairs_Office> getAllS_A_O() {
        return student_affairs_officeDao.getAllS_A_O();
    }

    @Override
    public List<Student_Affairs_Office> getS_A_O(Map map) {
        return student_affairs_officeDao.getS_A_O(map);
    }

    @Override
    public int insertS_A_O(Map map) {
        return student_affairs_officeDao.insertS_A_O(map);
    }

    @Override
    public int updateS_A_O(Map map) {
        return student_affairs_officeDao.updateS_A_O(map);
    }

    @Override
    public int deleteS_A_O(Map map) {
        return student_affairs_officeDao.deleteS_A_O(map);
    }
}
