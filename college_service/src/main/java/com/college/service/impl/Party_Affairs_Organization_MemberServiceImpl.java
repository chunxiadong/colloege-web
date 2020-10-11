package com.college.service.impl;

import com.college.dao.Party_Affairs_Organization_MemberDao;
import com.college.domain.Party_Affairs_Organization_Member;
import com.college.service.Party_Affairs_Organization_MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Party_Affairs_Organization_MemberServiceImpl implements Party_Affairs_Organization_MemberService {
    @Autowired
    private Party_Affairs_Organization_MemberDao party_affairs_organization_memberDao;
    @Override
    public List<Party_Affairs_Organization_Member> getAll() {
        return party_affairs_organization_memberDao.getAll();
    }

    @Override
    public List<Party_Affairs_Organization_Member> getSome(Map map) {
        return getSome(map);
    }

    @Override
    public int insert(Map map) {
        return party_affairs_organization_memberDao.insert(map);
    }

    @Override
    public int update(Map map) {
        return party_affairs_organization_memberDao.update(map);
    }

    @Override
    public int delete(Map map) {
        return party_affairs_organization_memberDao.delete(map);
    }
}
