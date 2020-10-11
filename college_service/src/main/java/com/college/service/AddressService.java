package com.college.service;

import com.college.domain.Address;

import java.util.List;
import java.util.Map;

//AddressService
public interface AddressService {
    //根据条件查找
    List<Address> getAddress(Map map);
    //查找所有
    List<Address> getAllAddress();
    //插入
    int insertAddress(Map map);
    //删除
    int deleteAddress(Map map);
    //更新
    int updateAddress(Map map);
}
