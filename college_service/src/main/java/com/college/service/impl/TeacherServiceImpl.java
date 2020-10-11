package com.college.service.impl;

import com.college.dao.TeacherDao;
import com.college.domain.Teacher;
import com.college.service.TeacherService;
import com.college.utils.SetLogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TeacherServiceImpl implements TeacherService {
    static{
        SetLogUtil.setLog(TeacherServiceImpl.class).info("==进入TeacherServiceImpl==");
    }

    @Autowired
    private TeacherDao teacherDao;


    @Override
    public List<Teacher> getTeacher(Map map) {
        return teacherDao.getTeacher(map);
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherDao.getAllTeacher();
    }

    @Override
    public int insertTeacher(Map map) {
        return teacherDao.insertTeacher(map);
    }

    @Override
    public int deleteTeacher(Map map) {
        return teacherDao.deleteTeacher(map);
    }

    @Override
    public int updateTeacher(Map map) {
        return teacherDao.updateTeacher(map);
    }
}