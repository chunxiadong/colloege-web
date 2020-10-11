package com.college.service.impl;

import com.college.dao.Party_Affairs_OrganizationDao;
import com.college.domain.Party_Affairs_Organization;
import com.college.service.Party_Affairs_OrganizationService;
import com.college.utils.SetLogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Party_Affairs_OrganizationServiceImpl implements Party_Affairs_OrganizationService {
    static{
        SetLogUtil.setLog(Party_Affairs_OrganizationServiceImpl.class).info("==进入Party_Affairs_OrganizationServiceImpl===");
    }
    @Autowired
    private Party_Affairs_OrganizationDao party_affairs_organizationDao;
    @Override
    public List<Party_Affairs_Organization> getAllP_A_O() {
        return party_affairs_organizationDao.getAllP_A_O();
    }

    @Override
    public List<Party_Affairs_Organization> getP_A_O(Map map) {
        return party_affairs_organizationDao.getP_A_O(map);
    }

    @Override
    public int insertP_A_O(Map map) {
        return party_affairs_organizationDao.insertP_A_O(map);
    }

    @Override
    public int deleteP_A_O(Map map) {
        return party_affairs_organizationDao.deleteP_A_O(map);
    }

    @Override
    public int updateP_A_O(Map map) {
        return party_affairs_organizationDao.updateP_A_O(map);
    }
}
