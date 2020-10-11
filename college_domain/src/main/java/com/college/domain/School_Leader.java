package com.college.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* 学校领导
* **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class School_Leader {
private Integer leader_ID;//负责工作
private String leader_work;//联系单位
private String leader_contact_unit;//
private String leader_office_location;//
private String leader_phone;//
private String leader_email;//
private String leader_name;//
private String leader_title;//
}
