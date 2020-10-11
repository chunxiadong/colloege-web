package com.college.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//成员
public class Party_Affairs_Organization_Member {
    private Integer party_member_ID;
    private String party_member_name;//党支部成员姓名
    private String party_member_title;//党支部成员职务
    private String belong_to_party;//所属党支部
}
