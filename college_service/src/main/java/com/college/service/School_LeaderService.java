package com.college.service;

import com.college.domain.School_Leader;

import java.util.List;
import java.util.Map;

//
public interface School_LeaderService {
    List<School_Leader> getAllLeader();
    List<School_Leader> getLeader(Map map);
    int insertSchool_Leader(Map map);
    int updateSchool_Leader(Map map);
    int deleteSchool_Leader(Map map);
}
