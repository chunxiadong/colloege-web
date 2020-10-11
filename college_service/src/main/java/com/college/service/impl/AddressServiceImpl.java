package com.college.service.impl;

import com.college.dao.AddressDao;
import com.college.domain.Address;
import com.college.service.AddressService;
import com.college.utils.SetLogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AddressServiceImpl implements AddressService {
    static{
        SetLogUtil.setLog(AddressServiceImpl.class).info("==进入AddressServiceImpl===");
    }
    @Autowired
    private AddressDao addressDao;
    @Override
    public List<Address> getAddress(Map map) {
        return addressDao.getAddress(map);
    }

    @Override
    public List<Address> getAllAddress() {
        return addressDao.getAllAddress();
    }

    @Override
    public int insertAddress(Map map) {
        return addressDao.insertAddress(map);
    }

    @Override
    public int deleteAddress(Map map) {
        return addressDao.deleteAddress(map);
    }

    @Override
    public int updateAddress(Map map) {
        return addressDao.updateAddress(map);
    }
}
