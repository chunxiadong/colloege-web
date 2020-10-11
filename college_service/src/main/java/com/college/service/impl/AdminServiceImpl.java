package com.college.service.impl;

import com.college.dao.AdminDao;
import com.college.domain.Admin;
import com.college.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {
@Autowired
    private AdminDao adminDao;
    @Override
    public List<Admin> getAllAdmin() {
        return adminDao.getAllAdmin();
    }

    @Override
    public int insertAdmin(Map map) {
        return adminDao.insertAdmin(map);
    }

    @Override
    public int updateAdmin(Map map) {
        return adminDao.updateAdmin(map);
    }

    @Override
    public int deleteAdmin(Map map) {
        return adminDao.deleteAdmin(map);
    }
}
