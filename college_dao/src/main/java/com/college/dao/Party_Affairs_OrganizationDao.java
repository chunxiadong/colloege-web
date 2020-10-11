package com.college.dao;

import com.college.domain.Party_Affairs_Organization;

import java.util.List;
import java.util.Map;

/*
* 党支部
* */
public interface Party_Affairs_OrganizationDao {
    List<Party_Affairs_Organization> getAllP_A_O();
    List<Party_Affairs_Organization> getP_A_O(Map map);
    int insertP_A_O(Map map);
    int deleteP_A_O(Map map);
    int updateP_A_O(Map map);
}
