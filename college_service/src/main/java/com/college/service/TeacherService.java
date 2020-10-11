package com.college.service;

import com.college.domain.Teacher;

import java.util.List;
import java.util.Map;
//

public interface TeacherService {
    //根据条件查找
    List<Teacher> getTeacher(Map map);
    //查找所有
    List<Teacher> getAllTeacher();
    //插入
    int insertTeacher(Map map);
    //删除
    int deleteTeacher(Map map);
    //更新
    int updateTeacher(Map map);
}