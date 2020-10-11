package com.college.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* 党支部
* */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Party_Affairs_Organization {
    private Integer party_ID;
    private String party_name;//党支部名称
    private String party_honor;//党支部荣誉
}
