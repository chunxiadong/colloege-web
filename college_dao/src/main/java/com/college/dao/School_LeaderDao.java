package com.college.dao;

import com.college.domain.School_Leader;

import java.util.List;
import java.util.Map;

/*
* 学院领导
* */
public interface School_LeaderDao {
List<School_Leader> getAllLeader();
List<School_Leader> getLeader(Map map);
int insertSchool_Leader(Map map);
int updateSchool_Leader(Map map);
int deleteSchool_Leader(Map map);
}
