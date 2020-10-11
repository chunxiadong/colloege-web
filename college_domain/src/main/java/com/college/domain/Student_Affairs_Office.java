package com.college.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 学工部
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student_Affairs_Office {
    private Integer ID;
    private String name;//学工部_成员姓名
    private String title;//学工部_成员职务
    private String phone;//学工部_办公电话
    private String location;//学工部_办公地点
    private String email;//学工部_成员邮箱
    private String motto;//学工部_带班格言
}
