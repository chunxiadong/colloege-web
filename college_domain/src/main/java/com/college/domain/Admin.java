package com.college.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//管理员
public class Admin {
    private Integer admin_id;
    private String admin_name;
    private String admin_pwd;

}
