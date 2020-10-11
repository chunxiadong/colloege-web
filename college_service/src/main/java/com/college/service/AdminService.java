package com.college.service;

import com.college.domain.Admin;

import java.util.List;
import java.util.Map;

//
public interface AdminService {
    List<Admin> getAllAdmin();
    int insertAdmin(Map map);
    int updateAdmin(Map map);
    int deleteAdmin(Map map);
}
