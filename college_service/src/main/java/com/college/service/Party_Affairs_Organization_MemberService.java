package com.college.service;

import com.college.domain.Party_Affairs_Organization_Member;

import java.util.List;
import java.util.Map;

//
public interface Party_Affairs_Organization_MemberService {
    List<Party_Affairs_Organization_Member> getAll();
    List<Party_Affairs_Organization_Member> getSome(Map map);
    int insert(Map map);
    int update(Map map);
    int delete(Map map);
}
