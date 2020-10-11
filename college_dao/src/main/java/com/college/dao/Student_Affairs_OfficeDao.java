package com.college.dao;

import com.college.domain.Student_Affairs_Office;

import java.util.List;
import java.util.Map;

/*
* 学工部
* */
public interface Student_Affairs_OfficeDao {
    List<Student_Affairs_Office> getAllS_A_O();
    List<Student_Affairs_Office> getS_A_O(Map map);
    int insertS_A_O(Map map);
    int updateS_A_O(Map map);
    int deleteS_A_O(Map map);
}
