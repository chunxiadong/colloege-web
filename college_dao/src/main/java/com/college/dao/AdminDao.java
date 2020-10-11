package com.college.dao;

import com.college.domain.Admin;

import java.util.List;
import java.util.Map;

//管理员
public interface AdminDao {
    List<Admin> getAllAdmin();
    int insertAdmin(Map map);
    int updateAdmin(Map map);
    int deleteAdmin(Map map);
}
