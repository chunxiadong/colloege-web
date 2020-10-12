package com.college.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Address {
    private String address_name;//链接地址名
    private String address;//链接地址
    private Integer ID;
    private String AddressType;//链接类型
    private Date createDate;//创建时间
    private String status;//审核状态
}
