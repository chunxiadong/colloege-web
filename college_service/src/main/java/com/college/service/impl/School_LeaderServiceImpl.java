package com.college.service.impl;

import com.college.dao.School_LeaderDao;
import com.college.domain.School_Leader;
import com.college.service.School_LeaderService;
import com.college.utils.SetLogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class School_LeaderServiceImpl implements School_LeaderService {
    static{
        SetLogUtil.setLog(School_LeaderServiceImpl.class).info("==进入School_LeaderServiceImpl===");
    }
    @Autowired
    private School_LeaderDao school_leaderDao;
    @Override
    public List<School_Leader> getAllLeader() {
        return school_leaderDao.getAllLeader();
    }

    @Override
    public List<School_Leader> getLeader(Map map) {
        return school_leaderDao.getLeader(map);
    }

    @Override
    public int insertSchool_Leader(Map map) {
        return school_leaderDao.insertSchool_Leader(map);
    }

    @Override
    public int updateSchool_Leader(Map map) {
        return school_leaderDao.updateSchool_Leader(map);
    }

    @Override
    public int deleteSchool_Leader(Map map) {
        return school_leaderDao.deleteSchool_Leader(map);
    }
}
