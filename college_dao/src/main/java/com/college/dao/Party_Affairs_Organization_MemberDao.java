package com.college.dao;

import com.college.domain.Party_Affairs_Organization_Member;

import java.util.List;
import java.util.Map;

/*
* 党支部成员
* */
public interface Party_Affairs_Organization_MemberDao {
    List<Party_Affairs_Organization_Member> getAll();
    List<Party_Affairs_Organization_Member> getSome(Map map);
    int insert(Map map);
    int update(Map map);
    int delete(Map map);
}
